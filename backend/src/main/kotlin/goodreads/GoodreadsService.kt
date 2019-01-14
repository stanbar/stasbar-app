/*
 * Copyright 2019 Stanislaw stasbar Baranski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *          __             __
 *    _____/ /_____ ______/ /_  ____ ______
 *   / ___/ __/ __ `/ ___/ __ \/ __ `/ ___/
 *  (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
 * /____/\__/\__,_/____/_.___/\__,_/_/
 *            stasbar@stasbar.com
 */

package com.stasbar.app.goodreads

import com.stasbar.app.Config
import com.stasbar.app.models.Book
import com.stasbar.app.models.Quote
import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.Duration

interface GoodreadsService {
  @Headers("Accept: */*")
  @GET("/review/list")
  fun getAllBooks(
    @Query("id") id: String, // Goodreads id of the user
    @Query("key") key: String, //Developer key (required)

    @Query("shelf") shelf: String? = null, // read, currently-reading, to-read, etc. (optional)
    @Query("sort") sort: String? = null, // title, author, cover, rating, year_pub, date_pub, date_pub_edition, date_started, date_read, date_updated, date_added, recommender, avg_rating, num_ratings, review, read_count, votes, random, comments, notes, isbn, isbn13, asin, num_pages, format, position, shelves, owned, date_purchased, purchase_location, condition (optional)
    @Query("order") order: String? = null, //a, d (optional)
    @Query("search") search: String? = null, //query text to match against member's books (optional)
    @Query("page") page: Int? = null,// 1-N (optional)
    @Query("per_page") perPage: Int? = null, //1-200 (optional)
    @Query("v") v: Int = 2
  ): Deferred<GoodreadsResponse>

  @GET("/api/author_url/{id}")
  fun findAuthorByName(
    @Path("id") id: String, // Author name
    @Query("key") key: String //Developer key (required)
  ): Deferred<GoodreadsSearchAuthorResponse>

  @GET("/search/index.xml")
  fun findBooksByTitleOrIsbn(
    @Query("q") titleOrIsbn: String, // Book title or ISBN
    @Query("search") field: String? = null, // Field to search, one of 'title', 'author', or 'all' (default is 'all')
    @Query("key") key: String //Developer key (required)
  ): Deferred<GoodreadsSearchBookResponse>
}

class GoodreadsApi(private val baseUrl: String, private val service: GoodreadsService) {

  suspend fun getAllReviews(): List<GoodreadsReview> {
    val perPage = 50
    val initialResponse = getAllBooks(
      id = Config.GOODREADS_USER_ID,
      perPage = perPage
    ).await()

    val totalBooks = initialResponse.reviews.total
    val booksRemaining = totalBooks - perPage
    val pages = Math.ceil(booksRemaining.toDouble() / perPage.toDouble())
    return List(pages.toInt()) { page ->
      getAllBooks(
        id = Config.GOODREADS_USER_ID,
        perPage = perPage,
        page = page + 2
      )
    }
      .map { it.await() }
      .union(setOf(initialResponse))
      .flatMap { it.reviews.reviews }
  }

  suspend fun getAllQuotes(): List<Quote> = coroutineScope {
    val pages = 10
    List(pages) { page ->
      async(Dispatchers.IO) {
        val doc =
          Jsoup.connect("$baseUrl/quotes/list?key=${Config.GOODREADS_API_KEY}&v=2&id=${Config.GOODREADS_USER_ID}&page=${page + 1}")
            .get()

        val quotes = doc.select(".quoteText")
        quotes.map { mapElementToQuote(it) }.toSet()
      }
    }
      .map { it.await() }
      .reduce { acc, deferred -> acc.union(deferred) }
      .also { logger.debug("Fetched ${it.size} books from goodreads api") }
      .toList()

  }

  private suspend fun mapElementToQuote(quoteElement: Element): Quote {
    val authorName = quoteElement.selectFirst(".authorOrTitle").ownText().substringBeforeLast(",")
    val bookTitle = quoteElement
      .selectFirst("[id^=quote_book_link]")
      ?.selectFirst(".authorOrTitle")
      ?.ownText()
    val bookId = quoteElement.selectFirst("[id^=quote_book_link_]")
      ?.id()?.substringAfter("quote_book_link_")
    logger.debug("$bookTitle -> $bookId")

    val book = if (bookTitle != null) findBookByTitle(bookTitle) else null

    val content = quoteElement.ownText().substringAfter("“").substringBeforeLast("”")
    return Quote(
      text = content,
      author = authorName,
      book = book
    )
  }

  private suspend fun getAllBooks(
    id: String,
    shelf: String? = null,
    sort: String? = null,
    order: String? = null,
    search: String? = null,
    page: Int? = null,
    perPage: Int? = null
  ) = oncePerSecond {
    service.getAllBooks(id, Config.GOODREADS_API_KEY, shelf, sort, order, search, page, perPage)
  }

  private suspend fun findBooksByTitleOrIsbn(
    titleOrIsbn: String,
    field: String? = null
  ) = oncePerSecond {
    service.findBooksByTitleOrIsbn(titleOrIsbn, field, Config.GOODREADS_API_KEY)
  }

  private val alreadyFoundBooks = mutableMapOf<String, Book?>()
  private suspend fun findBookByTitle(bookTitle: String): Book? {
    return if (alreadyFoundBooks.contains(bookTitle))
      alreadyFoundBooks[bookTitle]
    else {
      findBooksByTitleOrIsbn(bookTitle).await().search.results.firstOrNull()?.bestBook?.let {
        Book(
          title = it.title,
          author = it.author.name,
          imageUrl = it.imageUrl,
          smallImageUrl = it.smallImageUrl,
          rating = 0,
          shelves = listOf()
        )
      }.also {
        alreadyFoundBooks[bookTitle] = it
      }
    }
  }


  private val oncePerSecondMutex = Mutex()
  private var lastRequestTimestamp = 0L

  private suspend fun <R> oncePerSecond(request: () -> R): R {
    oncePerSecondMutex.withLock {
      val lastRequestMillisDiff = System.currentTimeMillis() - lastRequestTimestamp
      val period = Duration.ofSeconds(1).toMillis()
      if (lastRequestMillisDiff < period) {
        delay(period - lastRequestMillisDiff)
      }
      lastRequestTimestamp = System.currentTimeMillis()
    }
    return request()
  }
}

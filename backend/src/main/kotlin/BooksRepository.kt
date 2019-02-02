/*
 * Copyright 2019 Stanislaw Baranski @stasbar
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

package com.stasbar.app

import com.stasbar.app.database.BooksDatabase
import com.stasbar.app.goodreads.GoodreadsApi
import com.stasbar.app.goodreads.GoodreadsReview
import com.stasbar.app.googlebooks.GoogleBooksApi
import com.stasbar.app.models.Book
import com.stasbar.app.models.Shelf
import googlebooks.GoogleBooksSearchResult
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

import retrofit2.HttpException
import java.net.HttpURLConnection
import java.net.URL


class BooksRepository(
  private val goodreadsApi: GoodreadsApi,
  private val googleBooksApi: GoogleBooksApi,
  private val database: BooksDatabase
) {
  suspend fun getAllQuotes(limit: Int = -1) = database.getAllQuotes(limit)
  suspend fun getAllBooks() = database.getAllBooks()
  suspend fun getBooksFromShelf(shelf: String) = database.getBooksFromShelf(shelf)

  suspend fun fetchAllQuotes() {
    val quotes = goodreadsApi.getAllQuotes()
    database.insertOrUpdateQuotes(quotes)
  }

  suspend fun fetchAllBooks() {
    val books = coroutineScope {
      goodreadsApi.getAllReviews().map { async { connectWithBestBookCover(it) } }
    }
    database.insertOrUpdateBooks(books.awaitAll())
  }

  private suspend fun connectWithBestBookCover(review: GoodreadsReview): Book {
    val isbn = review.book.isbn ?: review.book.isbn13
    val googleBooksCall = lazy { googleBooksApi.getBookByIsbn(isbn) }
    val smallImageUrl = findBestCoverImageAvailable(isbn, "S", googleBooksCall, review)
    val imageUrl = findBestCoverImageAvailable(isbn, "L", googleBooksCall, review)
    return Book(
      title = review.book.titleWithoutSeries,
      rating = review.rating,
      isbn10 = review.book.isbn,
      isbn13 = review.book.isbn13,
      author = review.book.authors[0].name,
      goodreadsId = review.book.id.content,
      imageUrl = imageUrl,
      smallImageUrl = smallImageUrl,
      shelves = review.shelves.map { Shelf(it.name) }
    )
  }

  private suspend fun findBestCoverImageAvailable(
    isbn: String?,
    size: String,
    googleBooksCall: Lazy<Deferred<GoogleBooksSearchResult>>,
    review: GoodreadsReview
  ): String {
    return try {
      val openLibraryLink = "http://covers.openlibrary.org/b/isbn/$isbn-$size.jpg?default=false"
      if (isCoverAvailableOnOpenLibrary(openLibraryLink))
        openLibraryLink
      else throw Exception("Could not find image with this ISBN code")
    } catch (e: Exception) {
      val googleSearchResult = try {
        googleBooksCall.value.await()
      } catch (e: HttpException) {
        null
      }
      if (size == "M" || size == "L")
        if (isbn != null)
          googleSearchResult?.items?.get(0)?.volumeInfo?.imageLinks?.thumbnail
            ?: review.book.imageUrl else review.book.imageUrl
      else
        if (isbn != null)
          googleSearchResult?.items?.get(0)?.volumeInfo?.imageLinks?.smallThumbnail
            ?: review.book.smallImageUrl else review.book.smallImageUrl

    }
  }

  // https://openlibrary.org/dev/docs/api/covers
  private fun isCoverAvailableOnOpenLibrary(link: String): Boolean {
    with(URL(link).openConnection() as HttpURLConnection) {
      requestMethod = "HEAD"
      connect()
      return responseCode == HttpURLConnection.HTTP_OK
    }
  }

}

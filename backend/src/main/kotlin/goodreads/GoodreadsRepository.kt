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

import com.stasbar.app.database.BooksDatabase
import com.stasbar.app.models.Book
import mu.KotlinLogging

val logger = KotlinLogging.logger {}

class GoodreadsRepository(private val goodreadsApi: GoodreadsApi, private val database: BooksDatabase) {

  suspend fun getAllQuotes() = database.getAllQuotes()
  suspend fun getAllBooks() = database.getAllBooks()

  suspend fun fetchAllQuotes() {
    val quotes = goodreadsApi.getAllQuotes()
    database.insertOrUpdateQuotes(quotes)
  }

  suspend fun fetchAllBooks() {
    val books = goodreadsApi.getAllReviews().map { it.toBook() }
    database.insertOrUpdateBooks(books)
  }

  private fun GoodreadsReview.toBook() =
    Book(
      title = book.titleWithoutSeries,
      rating = rating,
      isbn10 = book.isbn,
      isbn13 = book.isbn13,
      author = book.authors[0].name,
      goodreadsId = book.id.content,
      imageUrl = book.imageUrl,
      smallImageUrl = book.smallImageUrl
    )
}

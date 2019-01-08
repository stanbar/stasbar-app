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

package com.stasbar.app.database

import com.stasbar.app.models.*
import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.withContext
import mu.KotlinLogging
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.concurrent.Executors


class H2Database(poolSize: Int, jdbcConnectionUrl: String, username: String, password: String) : BooksDatabase {
    private val logger = KotlinLogging.logger { }
    private val dispatcher: ExecutorCoroutineDispatcher = Executors.newFixedThreadPool(poolSize).asCoroutineDispatcher()

    init {
        logger.info("Using jdbc url: $jdbcConnectionUrl")
        Database.connect(
            jdbcConnectionUrl,
            "org.h2.Driver",
            username,
            password
        )
        transaction {
            SchemaUtils.create(Books, Quotes)
        }
    }

    override suspend fun getAllBooks(): List<Book> = withContext(dispatcher) {
        transaction {
            (Books).selectAll()
                .map { it.toBook() }
        }
    }

    override suspend fun insertOrUpdateBooks(books: List<Book>) {
        withContext(dispatcher) {
            transaction {
                books.forEach { book ->
                    if (Books.select { Books.hash eq book.hash }.firstOrNull() == null) {
                        insertBook(book)
                    } else {
                        updateBook(book)
                    }
                }
            }
        }
    }


    override suspend fun insertOrUpdateBook(book: Book) {
        withContext(dispatcher) {
            transaction {
                if (Books.select { Books.hash eq book.hash }.firstOrNull() == null) {
                    insertBook(book)
                } else {
                    updateBook(book)
                }
            }
        }
    }

    private fun insertBook(book: Book) {
        logger.debug("about to insert $book")
        Books.insert {
            it[hash] = book.hash
            it[title] = book.title
            it[rating] = book.rating
            it[goodreadsId] = book.goodreadsId
            it[author] = book.author
        }
    }

    private fun updateBook(book: Book) {
        logger.debug("about to update $book")
        Books.update {
            it[hash] = book.hash
            it[title] = book.title
            it[rating] = book.rating
            it[goodreadsId] = book.goodreadsId
            it[author] = book.author
        }
    }


    override suspend fun getAllQuotes(): List<Quote> = withContext(dispatcher) {
        transaction {
            (Quotes leftJoin Books).selectAll()
                .also { println("selected ${it.count()} quotes") }
                .map { it.toQuote() }
        }
    }

    override suspend fun insertOrUpdateQuotes(quotes: List<Quote>) {
        withContext(dispatcher) {
            transaction {
                quotes.forEach { quote ->
                    val book = quote.book?.let {
                        Books
                            .select {
                                (Books.hash eq it.hash) or (Books.title like it.title)
                            }
                            .firstOrNull()
                            ?.toBook()
                    }
                    if (Quotes.select { Quotes.hash eq quote.hash }.firstOrNull() == null) {
                        insertQuote(quote, book)
                    } else {
                        updateQuote(quote, book)
                    }
                }
            }
        }
    }

    override suspend fun insertOrUpdateQuote(quote: Quote) {
        withContext(dispatcher) {
            transaction {
                val book = quote.book?.let {
                    Books
                        .select {
                            (Books.hash eq it.hash) or (Books.title like it.title)
                        }
                        .firstOrNull()
                        ?.toBook()
                }
                if (Quotes.select { Quotes.hash eq quote.hash }.firstOrNull() == null) {
                    insertQuote(quote, book)
                } else {
                    updateQuote(quote, book)
                }
            }
        }
    }

    private fun updateQuote(quote: Quote, book: Book?) {
        logger.debug("about to update quote $quote")
        logger.debug("with book $book")

        Quotes.update {
            it[hash] = quote.hash
            it[text] = quote.text
            it[author] = quote.author
            it[bookHash] = book?.hash
        }
    }

    private fun insertQuote(quote: Quote, book: Book?) {
        logger.debug("about to insert quote $quote")
        logger.debug("with book $book")
        Quotes.insert {
            it[hash] = quote.hash
            it[text] = quote.text
            it[author] = quote.author
            it[bookHash] = book?.hash
        }
    }

}

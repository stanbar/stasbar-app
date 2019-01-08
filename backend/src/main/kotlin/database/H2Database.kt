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


class H2Database(poolSize: Int, jdbcConnectionUrl: String, username: String, password: String) :
    BooksDatabase {
    val logger = KotlinLogging.logger { }
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

    override suspend fun getAllQuotes(): List<Quote> = withContext(dispatcher) {
        transaction {
            (Quotes innerJoin Books).selectAll()
                .map { it.toQuote() }
        }
    }

    override suspend fun getAllBooks(): List<Book> = withContext(dispatcher) {
        transaction {
            (Books).selectAll()
                .map { it.toBook() }
        }
    }

    override suspend fun insertBook(book: Book) {
        withContext(dispatcher) {
            transaction {
                this@H2Database.logger.debug("about to insert $book")
                Books.insert {
                    it[Books.title] = book.title
                    it[Books.rating] = book.rating
                    it[Books.goodreadsId] = book.goodreadsId
                    it[Books.author] = book.author
                }
            }
        }
    }

    override suspend fun insertQuote(quote: Quote) {
        withContext(dispatcher) {
            transaction {
                val book = quote.book?.goodreadsId?.let {
                    Books.select { Books.goodreadsId eq it }.firstOrNull()
                }
                Quotes.insert {
                    it[Quotes.text] = quote.text
                    it[Quotes.author] = quote.author
                    it[Quotes.bookId] = book?.get(Books.id)
                }
            }
        }
    }
}

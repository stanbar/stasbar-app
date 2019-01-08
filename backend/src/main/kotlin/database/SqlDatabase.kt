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
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection
import java.util.concurrent.Executors


class SqlDatabase(poolSize: Int, jdbcConnectionUrl: String) : BooksDatabase {
    val logger = KotlinLogging.logger { }
    private val dispatcher: ExecutorCoroutineDispatcher = Executors.newFixedThreadPool(poolSize).asCoroutineDispatcher()

    init {
        logger.info("Using jdbc url: $jdbcConnectionUrl")
        Database.connect(
            jdbcConnectionUrl,
            driver = "org.sqlite.JDBC"
        )
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
        transaction {
            addLogger(StdOutSqlLogger)
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
                Books.insert {
                    it[Books.title] = book.title
                    it[Books.rating] = book.rating
                    it[Books.goodreadsId] = book.goodreadsId
                }
            }
        }
    }

    override suspend fun insertQuote(quote: Quote) {
        withContext(dispatcher) {
            transaction {
                val book = Books.select {
                    Books.id eq quote.book?.id
                }.firstOrNull()

                Quotes.insert {
                    it[Quotes.text] = quote.text
                    it[Quotes.author] = quote.author
                    it[Quotes.bookId] = book?.get(Books.id)
                }
            }
        }
    }
}

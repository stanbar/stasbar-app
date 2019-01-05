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

package com.stasbar.app

import io.ktor.application.Application
import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.dao.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object Quotes : IntIdTable() {
    val text = text("text")
    val timestamp = integer("timestamp")
    val tag = varchar("tag", 50).nullable()
    val authorId = reference("authorId", Authors).nullable()
    val bookId = reference("bookId", Books).nullable()

    fun from(resultRow: ResultRow) = Quote(
        id = resultRow[Quotes.id].value,
        text = resultRow[Quotes.text],
        author = Authors.from(resultRow),
        book = Books.from(resultRow)
    )
}

data class Quote(
    val id: Int? = null,
    val text: String,

    //optional
    val author: Author? = null,
    val book: Book? = null
)

object Tags : IntIdTable() {
    val name = varchar("name", 50)
}

object Authors : IntIdTable() {
    val name = varchar("name", length = 50)
    val goodreadsId = integer("goodreadsId").nullable()

    fun from(resultRow: ResultRow) = Author(
        id = resultRow[Authors.id].value,
        name = resultRow[Authors.name],
        goodreadsId = resultRow[Authors.goodreadsId]
    )
}

data class Author(
    val id: Int? = null,
    val name: String,

    //goodreads
    val goodreadsId: Int? = null,
    val imageUrl: String? = null,
    val smallImageUrl: String? = null
)

object Books : IntIdTable() {
    val title = varchar("title", length = 50)
    val rating = integer("rating").nullable()
    val goodreadsId = integer("goodreadsId").nullable()

    fun from(resultRow: ResultRow) = Book(
        id = resultRow[Books.id].value,
        title = resultRow[Books.title],
        rating = resultRow[Books.rating],
        goodreadsId = resultRow[Books.goodreadsId]
    )
}

data class Book(
    val id: Int? = null,
    val title: String,
    val rating: Int? = null,

    //nullable
    val isbn10: String? = null,
    val isbn13: String? = null,
    val description: String? = null,
    val uri: String? = null,
    val authors: List<Author> = listOf(),

    //goodreads
    val goodreadsId: Int? = null,
    val imageUrl: String? = null,
    val smallImageUrl: String? = null,
    val largeImageUrl: String? = null
)


class SqliteDatabase(application: Application) {
    private val db: Database
    private val dispatcher: ExecutorCoroutineDispatcher

    init {
        val config = config.config("database")
        val connection = config.property("connection").getString()
        val poolSize = config.property("poolSize").getString().toInt()

        dispatcher = newFixedThreadPoolContext(poolSize, "database-pool")
        db = Database.connect(
            connection,
            driver = "org.sqlite.JDBC",
            user = Config.DATABASE_USER,
            password = Config.DATABASE_PASSWORD
        )

        transaction {
            SchemaUtils.create(Quotes, Authors)
        }
    }

    suspend fun getAllQuotes(): List<Quote> = withContext(dispatcher) {
        transaction {
            (Quotes innerJoin Authors innerJoin Books).selectAll()
                .map { Quotes.from(it) }
        }
    }

    suspend fun getAllAuthors(): List<Author> = withContext(dispatcher) {
        transaction {
            (Authors).selectAll()
                .map { Authors.from(it) }
        }
    }

    suspend fun getAllBooks(): List<Book> = withContext(dispatcher) {
        transaction {
            (Books).selectAll()
                .map { Books.from(it) }
        }
    }

    suspend fun insertBook(book: Book) = withContext(dispatcher) {
        transaction {
            Books.insert {
                it[Books.title] = book.title
                it[Books.goodreadsId] = book.goodreadsId
                it[Books.rating] = book.rating
            }
        }
    }

    suspend fun insertAuthor(author: Author) = withContext(dispatcher) {
        transaction {
            Authors.insert {
                it[Authors.name] = author.name
                it[Authors.goodreadsId] = author.goodreadsId
            }
        }
    }

    suspend fun insertQuote(quote: Quote) = withContext(dispatcher) {
        transaction {
            val author = Authors.select {
                Authors.id eq quote.author?.id
            }.firstOrNull()
            val book = Books.select {
                Books.id eq quote.book?.id
            }.firstOrNull()

            Quotes.insert {
                it[Quotes.text] = quote.text
                it[Quotes.authorId] = author?.get(Quotes.id)
                it[Quotes.bookId] = book?.get(Books.id)
            }
        }
    }
}

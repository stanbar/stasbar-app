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

package database

import com.stasbar.app.database.H2Database
import com.stasbar.app.models.Book
import com.stasbar.app.models.Books
import com.stasbar.app.models.Quote
import com.stasbar.app.models.Quotes
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class H2DatabaseTest {
    val database = H2Database(4, "jdbc:h2:file:./.database/test-stasbarapp", "root", "")
    //val database = H2Database(4, "jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;", "root", "")

    @Before
    fun setUp() {
        transaction {
            Quotes.deleteAll()
            Books.deleteAll()
        }
    }

    @Test
    fun getAllBooks() = runBlocking<Unit> {
        assertTrue(database.getAllBooks().isEmpty())

        database.insertOrUpdateBook(the7HabitsBook)
        assertEquals(1, database.getAllBooks().size)

        database.insertOrUpdateBook(the7HabitsBook)
        assertEquals(1, database.getAllBooks().size)
    }

    @Test
    fun getAllQuotes() = runBlocking<Unit> {
        assertTrue(database.getAllQuotes().isEmpty())

        database.insertOrUpdateQuote(the7HabitsQuote)
        assertEquals(1, database.getAllQuotes().size)

        database.insertOrUpdateQuote(the7HabitsQuote)
        assertEquals(1, database.getAllQuotes().size)

    }

    private val the7HabitsBook = Book(
        title = "The 7 Habits of Highly Effective People: Powerful Lessons in Personal Change",
        author = "Stephen R. Covey",
        rating = 5
    )

    private val the7HabitsQuote = Quote(
        text = "Most people do not listen with the intent to understand; they listen with the intent to reply",
        author = "Stephen R. Covey",
        book = the7HabitsBook
    )
    private val theOneThingBook = Book(
        title = "The majority of what you want will come from the minority of what you do",
        author = "Gary Keller",
        rating = 5
    )

    private val theOneThingBookQuote = Quote(
        text = "the majority of what you want will come from the minority of what you do",
        author = "Gary Keller",
        book = theOneThingBook
    )

    @Test
    fun insertBook() = runBlocking<Unit> {
        database.insertOrUpdateBook(the7HabitsBook)
        val actual = database.getAllBooks()[0]

        assertEquals(the7HabitsBook, actual)
    }


    @Test
    fun insertQuote() = runBlocking<Unit> {
        //database.insertBook(the7HabitsBook)
        assertTrue(database.getAllQuotes().isEmpty())
        database.insertOrUpdateQuote(the7HabitsQuote)

        assertEquals(1, database.getAllQuotes().size)
        val actual = database.getAllQuotes()[0]

        assertEquals(the7HabitsQuote.text, actual.text)
        assertEquals(the7HabitsQuote.author, actual.author)
        assertEquals(the7HabitsQuote.hash, actual.hash)
    }

    @Test
    fun insertQuoteConnectedToBook() = runBlocking<Unit> {
        database.insertOrUpdateBook(the7HabitsBook)
        assertTrue(database.getAllQuotes().isEmpty())

        database.insertOrUpdateQuote(the7HabitsQuote)
        assertEquals(1, database.getAllQuotes().size)

        val actual = database.getAllQuotes()[0]
        assertEquals(the7HabitsQuote, actual)
    }


    @Test
    fun `add books in batch`() = runBlocking<Unit> {
        val books = listOf(the7HabitsBook, theOneThingBook)
        database.insertOrUpdateBooks(books)
        assertEquals(books, database.getAllBooks())
    }

    @Test
    fun `add quotes in batch`() = runBlocking<Unit> {
        val books = listOf(the7HabitsBook, theOneThingBook)
        database.insertOrUpdateBooks(books)
        val quotes = listOf(the7HabitsQuote, theOneThingBookQuote)
        database.insertOrUpdateQuotes(quotes)
        assertEquals(quotes, database.getAllQuotes())
    }
}
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
import com.stasbar.app.models.Quote
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class H2DatabaseTest {

    val database = H2Database(4, "jdbc:h2:mem:regular;DB_CLOSE_DELAY=-1;", "root", "")

    @Test
    fun getAllQuotes() = runBlocking<Unit> {
        database.getAllQuotes()
    }


    @Test
    fun getAllBooks() = runBlocking<Unit> {
        database.getAllBooks()

    }

    val the7habbitsBook = Book(
        title = "The 7 Habits of Highly Effective People: Powerful Lessons in Personal Change ",
        author = "Stephen R. Covey",
        rating = 5
    )

    @Test
    fun insertBook() = runBlocking<Unit> {
        database.insertBook(the7habbitsBook)
        val actual = database.getAllBooks()[0]
        assertEquals(the7habbitsBook, actual)
    }

    val the7habbitsQuote = Quote(
        text = "Most people do not listen with the intent to understand; they listen with the intent to reply",
        author = "Stephen R. Covey",
        book = the7habbitsBook
    )

    @Test
    fun insertQuote() = runBlocking<Unit> {
        database.insertQuote(the7habbitsQuote)
        println(database.getAllQuotes())
        //assertEquals(the7habbitsQuote, actual)

    }
}
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


import com.stasbar.app.BooksRepository
import com.stasbar.app.di.testModules
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import java.net.HttpURLConnection
import java.net.URL

class BooksRepositoryTest : KoinTest {
  private val booksRepository: BooksRepository by inject()

  @Before
  fun setUp() {
    startKoin {
      modules(testModules)
      environmentProperties()
      fileProperties()
    }
  }

  @After
  fun tearDown() {
    stopKoin()
  }

  @Test
  fun getAllQuotes() {

  }

  @Test
  fun getAllBooks() {
  }

  @Test
  fun fetchAllBooks() {
    runBlocking {
      booksRepository.fetchAllBooks()
    }
  }

  @Test
  fun fetchAllQuotes() {
    runBlocking {
      booksRepository.fetchAllQuotes()
    }
  }

  @Test(expected = Exception::class)
  fun `findBestCoverImageAvailable throw on empty isbn`() = runBlocking<Unit> {
    val openLibraryLink = "http://covers.openlibrary.org/b/isbn/-L.jpg?default=false"
    with(URL(openLibraryLink).openConnection() as HttpURLConnection) {
      requestMethod = "GET"
      connect()
      if (responseCode == HttpURLConnection.HTTP_OK)
        println("link looks fine $openLibraryLink")
      else throw Exception("Could not find image with this ISBN code")
    }
  }

  @Test(expected = Exception::class)
  fun `findBestCoverImageAvailable throw on invalid isbn`() = runBlocking<Unit> {
    val openLibraryLink = "http://covers.openlibrary.org/b/isbn/asdfafsd-L.jpg?default=false"
    with(URL(openLibraryLink).openConnection() as HttpURLConnection) {
      requestMethod = "GET"
      connect()
      if (responseCode == HttpURLConnection.HTTP_OK)
        println("link looks fine $openLibraryLink")
      else throw Exception("Could not find image with this ISBN code")
    }
  }

  @Test(expected = Exception::class)
  fun `findBestCoverImageAvailable throw on unknown isbn isbn`() = runBlocking<Unit> {
    val openLibraryLink = "http://covers.openlibrary.org/b/isbn/020143294311-L.jpg?default=false"
    with(URL(openLibraryLink).openConnection() as HttpURLConnection) {
      requestMethod = "GET"
      connect()

      if (responseCode == HttpURLConnection.HTTP_OK) {
        println("link looks fine $openLibraryLink")
      } else throw Exception("Could not find image with this ISBN code")
    }
  }
}

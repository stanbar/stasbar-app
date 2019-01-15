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

package googlebooks

import com.stasbar.app.di.testModules
import com.stasbar.app.googlebooks.GoogleBooksApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.KoinProperties
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.standalone.inject
import org.koin.test.KoinTest
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class GoogleBooksApiTest : KoinTest {
  private val googleBooksApi: GoogleBooksApi by inject()

  @Before
  fun setUp() {
    startKoin(testModules, properties = KoinProperties(useKoinPropertiesFile = true))
  }


  @After
  fun tearDown() {
    stopKoin()
  }

  @Test
  fun getBookByIsbn() = runBlocking<Unit> {
    val response = googleBooksApi.getBookByIsbn("0471592242").await()

    assertNotNull(response.items)
    val thumbnail = response.items!![0].volumeInfo!!.imageLinks!!.thumbnail!!
    assertEquals(
      thumbnail,
      "http://books.google.com/books/content?id=rB2mIvrHLxMC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
    )
    val smallThumbnail = response.items!![0].volumeInfo!!.imageLinks!!.smallThumbnail!!
    assertEquals(
      smallThumbnail,
      "http://books.google.com/books/content?id=rB2mIvrHLxMC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api"
    )
  }
}

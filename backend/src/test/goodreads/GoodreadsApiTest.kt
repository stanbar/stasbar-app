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

package goodreads

import com.stasbar.BaseKoinTest
import com.stasbar.app.goodreads.GoodreadsApi
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup
import org.junit.Test
import org.koin.test.inject
import kotlin.test.assertTrue

class GoodreadsApiTest : BaseKoinTest() {
  private val goodreadsApi: GoodreadsApi by inject()
  private val goodReadsApiKey: String by lazy { getKoin().getProperty<String>("GOODREADS_API_KEY") ?: throw Error() }
  private val goodReadsUserId: String by lazy { getKoin().getProperty<String>("GOODREADS_USER_ID") ?: throw Error() }

  @Test
  fun getAllReviews() {
    runBlocking {
      assertTrue(goodreadsApi.getAllReviews().size >= 167)
    }
  }

  @Test
  fun getAllQuotes() {
    runBlocking {
      assertTrue(goodreadsApi.getAllQuotes().size >= 71)
    }
  }

  @Test
  fun `extract quotes from website`() {
    val url =
      "https://www.goodreads.com/quotes/list?key=$goodReadsApiKey&v=2&id=$goodReadsUserId&page=1"
    println(url)
    val doc = Jsoup.connect(url).get()

    val quotes = doc.select(".quoteText")
    println("found ${quotes.size} quotes")

    quotes.forEach { it ->
      val parent = it.parent()

      val position = parent
        .selectFirst(".leftAlignedImage")
        .ownText().substring(1)
      println("[$position] ")


    }
  }


}

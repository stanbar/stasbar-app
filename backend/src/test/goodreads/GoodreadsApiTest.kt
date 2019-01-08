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

import com.stasbar.app.di.goodreadsModule
import com.stasbar.app.goodreads.GoodreadsApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.KoinProperties
import org.koin.standalone.StandAloneContext
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.standalone.inject
import org.koin.test.KoinTest
import kotlin.test.assertTrue

class GoodreadsApiTest : KoinTest {
    private val goodreadsApi: GoodreadsApi by inject()

    @Before
    fun setUp() {
        StandAloneContext.startKoin(listOf(goodreadsModule), properties = KoinProperties(useKoinPropertiesFile = true))
    }


    @After
    fun tearDown() {
        stopKoin()
    }

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
}
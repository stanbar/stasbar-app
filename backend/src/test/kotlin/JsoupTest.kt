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

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import org.junit.Test
import kotlin.system.measureTimeMillis

class JsoupTest {
    val BASE_URL = "https://www.goodreads.com"

    @Test
    internal fun fetchAllQuotes() = runBlocking {
        val pages = 10
        val time = measureTimeMillis {
            val tasks = List(pages) { page ->
                async(Dispatchers.IO) {
                    val doc =
                        Jsoup.connect("$BASE_URL/quotes/list?key=${Config.GOODREADS_API_KEY}&v=2&id=${Config.GOODREADS_USER_ID}&page=${page + 1}")
                            .get()

                    val quotes = doc.select(".quoteText")

                    quotes.map(::mapElementToQuote).toSet()
                }
            }

            val result: Set<Quote> = tasks
                .map { it.await() }
                .reduce { acc, deferred -> acc.union(deferred) }

            result.forEach { println("${it.text}- ${it.book?.title} ~${it.author?.name} ") }
        }

        println("took $time ms")
    }

    private fun mapElementToQuote(quoteElement: Element): Quote {
        val author = quoteElement.selectFirst(".authorOrTitle").ownText()
        val book = quoteElement
            .selectFirst("[id^=quote_book_link]")
            ?.selectFirst(".authorOrTitle")
            ?.ownText()
        val bookId = quoteElement.selectFirst("[id^=quote_book_link_]")
            ?.id()?.substringAfter("quote_book_link_")

        val content = quoteElement.ownText().substringAfter("“").substringBeforeLast("”")
        return Quote(
            text = content
        )
    }

}
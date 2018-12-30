package com.stasbar.app

import com.stasbar.app.models.Quote
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
                        Jsoup.connect("$BASE_URL/quotes/list?key=${Config.GOODREADS_API_KEY}&v=2&id=56108604-stanislaw-baranski&page=${page + 1}")
                            .get()

                    val quotes = doc.select(".quoteText")

                    quotes.map(::mapElementToQuote).toSet()
                }
            }

            val result: Set<Quote> = tasks
                .map { it.await() }
                .reduce { acc, deferred -> acc.union(deferred) }

            result.forEach { println("${it.content}- ${it.book} ~${it.author} ") }
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
            content = content,
            book = book,
            bookId = bookId,
            author = author
        )
    }

}
package com.stasbar.app

import org.jsoup.Jsoup
import org.junit.Test

class JsoupTest {
    val BASE_URL = "https://www.goodreads.com"

    @Test
    internal fun fetchQuotes() {
        for (page in 1..10) {
            val doc =
                Jsoup.connect("$BASE_URL/quotes/list?key=${Config.GOODREADS_API_KEY}&v=2&id=56108604-stanislaw-baranski&page=$page")
                    .get()

            val quotes = doc.select(".quoteText")
            quotes.forEach { quoteElement ->
                val author = quoteElement.selectFirst(".authorOrTitle").ownText()
                val book = quoteElement
                    .selectFirst("[id^=quote_book_link]")
                    ?.selectFirst(".authorOrTitle")
                    ?.ownText()
                val bookId = quoteElement.selectFirst("[id^=quote_book_link_]")
                    ?.id()?.substringAfter("quote_book_link_")

                val quoteText = quoteElement.ownText().substringAfter("“").substringBeforeLast("”")
                println("$book[$bookId] - $quoteText ~$author")
            }
        }

    }
}
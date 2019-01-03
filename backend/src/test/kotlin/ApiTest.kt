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

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.stasbar.app.goodreads.GoodreadsService
import com.stasbar.app.goodreads.XML
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.time.delay
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.jaxb.JaxbConverterFactory
import java.time.Duration


class ApiTest {
    val client = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://www.goodreads.com")
        .client(client)
        .addConverterFactory(JaxbConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val service = retrofit.create(GoodreadsService::class.java)

    @Test
    fun getAllBook() = runBlocking {
        val perPage = 50
        val initialResponse = service.getAllBooks(
            id = Config.GOODREADS_USER_ID,
            key = Config.GOODREADS_API_KEY,
            perPage = perPage
        ).await()

        val totalBooks = initialResponse.reviews.total
        val booksRemaining = totalBooks - perPage
        val pages = Math.ceil(booksRemaining.toDouble() / perPage.toDouble())
        val otherPages = List(pages.toInt()) { page ->
            async(Dispatchers.IO) {
                delay(Duration.ofSeconds((page * 2 + 1).toLong()))
                service.getAllBooks(
                    id = Config.GOODREADS_USER_ID,
                    key = Config.GOODREADS_API_KEY,
                    perPage = perPage,
                    page = page + 2
                )
            }
        }
        val books = otherPages.map {
            it.await().await()
        }.union(setOf(initialResponse))
            .flatMap { it.reviews.reviews }

        println(books.size)
        books.forEach {
            println(
                it.book.titleWithoutSeries
            )
        }
    }

    @Test
    fun getAllBookFromRead() = runBlocking {
        val response = service.getAllBooks(
            id = Config.GOODREADS_USER_ID,
            key = Config.GOODREADS_API_KEY,
            shelf = "read"
        ).await()


        println(response)
        println(XML.stringify(response))
    }


}
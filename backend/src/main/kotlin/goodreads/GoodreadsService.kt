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

package com.stasbar.app.goodreads

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.stasbar.app.Config
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.delay
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import mu.KotlinLogging
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jaxb.JaxbConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.Duration

interface GoodreadsService {
    @Headers("Accept: */*")
    @GET("/review/list")
    fun getAllBooks(
        @Query("id") id: String, // Goodreads id of the user
        @Query("key") key: String, //Developer key (required)

        @Query("shelf") shelf: String? = null, // read, currently-reading, to-read, etc. (optional)
        @Query("sort") sort: String? = null, // title, author, cover, rating, year_pub, date_pub, date_pub_edition, date_started, date_read, date_updated, date_added, recommender, avg_rating, num_ratings, review, read_count, votes, random, comments, notes, isbn, isbn13, asin, num_pages, format, position, shelves, owned, date_purchased, purchase_location, condition (optional)
        @Query("order") order: String? = null, //a, d (optional)
        @Query("search") search: String? = null, //query text to match against member's books (optional)
        @Query("page") page: Int? = null,// 1-N (optional)
        @Query("per_page") perPage: Int? = null, //1-200 (optional)
        @Query("v") v: Int = 2
    ): Deferred<GoodreadsResponse>

    @GET("/api/author_url/{id}")
    fun findAuthorByName(
        @Path("id") id: String, // Author name
        @Query("key") key: String //Developer key (required)
    ): Deferred<GoodreadsSearchAuthorResponse>

    @GET("/search/index.xml")
    fun findBooksByTitleOrIsbn(
        @Query("q") titleOrIsbn: String, // Book title or ISBN
        @Query("search") field: String? = null, // Field to search, one of 'title', 'author', or 'all' (default is 'all')
        @Query("key") key: String //Developer key (required)
    ): Deferred<GoodreadsSearchBookResponse>
}

object GoodreadsApi {
    private val logger = KotlinLogging.logger {}
    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
        .build()

    private val service = Retrofit.Builder()
        .baseUrl("https://www.goodreads.com")
        .client(client)
        .addConverterFactory(JaxbConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(GoodreadsService::class.java)


    suspend fun getAllBooks(
        id: String,
        shelf: String? = null,
        sort: String? = null,
        order: String? = null,
        search: String? = null,
        page: Int? = null,
        perPage: Int? = null
    ) = oncePerSecond {
        service.getAllBooks(id, Config.GOODREADS_API_KEY, shelf, sort, order, search, page, perPage)
    }


    suspend fun findAuthorByName(id: String) = oncePerSecond {
        service.findAuthorByName(id, Config.GOODREADS_API_KEY)
    }

    suspend fun findBooksByTitleOrIsbn(
        titleOrIsbn: String,
        field: String? = null
    ) = oncePerSecond {
        service.findBooksByTitleOrIsbn(titleOrIsbn, field, Config.GOODREADS_API_KEY)
    }

    private val oncePerSecondMutex = Mutex()
    private var lastRequestTimestamp = 0L

    private suspend fun <R> oncePerSecond(request: () -> R): R {
        oncePerSecondMutex.withLock {
            val lastRequestMillisDiff = System.currentTimeMillis() - lastRequestTimestamp
            val period = Duration.ofSeconds(1).toMillis()
            if (lastRequestMillisDiff < period) {
                logger.debug("Delaying ${period - lastRequestMillisDiff} millis")
                delay(period - lastRequestMillisDiff)
            }
            lastRequestTimestamp = System.currentTimeMillis()
        }
        return request()
    }
}
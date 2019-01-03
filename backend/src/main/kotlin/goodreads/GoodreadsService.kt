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

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GoodreadsService {
    @Headers("Accept: */*")
    @GET("/review/list")
    fun getAllBooks(
        @Query("id") id: String, // Goodreads id of the user
        @Query("key") key: String, //Developer key (required)
        @Query("v") v: Int = 2,
        @Query("shelf") shelf: String? = null, // read, currently-reading, to-read, etc. (optional)
        @Query("sort") sort: String? = null, // title, author, cover, rating, year_pub, date_pub, date_pub_edition, date_started, date_read, date_updated, date_added, recommender, avg_rating, num_ratings, review, read_count, votes, random, comments, notes, isbn, isbn13, asin, num_pages, format, position, shelves, owned, date_purchased, purchase_location, condition (optional)
        @Query("order") order: String? = null, //a, d (optional)
        @Query("search") search: String? = null, //query text to match against member's books (optional)
        @Query("page") page: Int? = null,// 1-N (optional)
        @Query("per_page") perPage: Int? = null //1-200 (optional)
    ): Deferred<GoodreadsResponse>
}
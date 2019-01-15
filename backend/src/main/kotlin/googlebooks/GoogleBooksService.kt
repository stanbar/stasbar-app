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

package com.stasbar.app.googlebooks

import googlebooks.GoogleBooksSearchResult
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

// sample https://www.googleapis.com/books/v1/volumes?q=isbn:0471592242
interface GoogleBooksService {
  @Headers("Accept: */*")
  @GET("/books/v1/volumes")
  fun getBookByIsbn(
    @Query("q") q: String,
    @Query("key") key: String,
    @Query("default") default: Boolean = false,
    @Query("fields") fields: String = "items(volumeInfo/imageLinks)"
  ): Deferred<GoogleBooksSearchResult>
}

class GoogleBooksApi(private val service: GoogleBooksService, private val apiKey: String) {
  fun getBookByIsbn(isbn: String) = service.getBookByIsbn("isbn:$isbn", apiKey)
}

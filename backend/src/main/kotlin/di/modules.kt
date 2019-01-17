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

package com.stasbar.app.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.stasbar.app.BooksRepository
import com.stasbar.app.database.BooksDatabase
import com.stasbar.app.database.H2Database
import com.stasbar.app.goodreads.GoodreadsApi
import com.stasbar.app.goodreads.GoodreadsService
import com.stasbar.app.googlebooks.GoogleBooksApi
import com.stasbar.app.googlebooks.GoogleBooksService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.jaxb.JaxbConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


val testCommonModule = module {
  single<OkHttpClient> {
    OkHttpClient.Builder()
      .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
      .build()
  }
  single<BooksDatabase> {
    H2Database(4, "jdbc:h2:file:./.database/test-stasbarapp", "root", "")
  }
}
val commonModule = module {
  single<OkHttpClient> {
    OkHttpClient.Builder()
      .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
      .build()
  }
  single<BooksDatabase> {
    H2Database(
      getProperty("db_thread_pool", 4),
      getProperty("jdbc_connection_url", "jdbc:h2:file:./.database/stasbarapp"),
      getProperty("DATABASE_USER"),
      getProperty("DATABASE_PASSWORD")
    )
  }
}
val goodreadsModule = module {
  single<GoodreadsService> {
    Retrofit.Builder()
      .baseUrl(getProperty("goodreads_base_url", "https://www.goodreads.com"))
      .client(get())
      .addConverterFactory(JaxbConverterFactory.create())
      .addCallAdapterFactory(CoroutineCallAdapterFactory())
      .build()
      .create(GoodreadsService::class.java)
  }

  single {
    GoodreadsApi(
      get(),
      getProperty("goodreads_base_url"),
      getProperty("GOODREADS_USER_ID"),
      getProperty("GOODREADS_API_KEY")
    )
  }
  single { BooksRepository(get(), get(), get()) }
}

val googleBooksModule = module {
  single<GoogleBooksService> {
    Retrofit.Builder()
      .baseUrl(getProperty("googlebooks_base_url", "https://www.googleapis.com"))
      .client(get())
      .addConverterFactory(MoshiConverterFactory.create())
      .addCallAdapterFactory(CoroutineCallAdapterFactory())
      .build()
      .create(GoogleBooksService::class.java)
  }
  single {
    System.getenv().forEach { t, u ->
      println("$t -> $u")
    }
    GoogleBooksApi(get(), getProperty("GOOGLEBOOKS_API_KEY"))
  }
}
val prodModules = listOf(commonModule, goodreadsModule, googleBooksModule)
val testModules = listOf(testCommonModule, goodreadsModule, googleBooksModule)

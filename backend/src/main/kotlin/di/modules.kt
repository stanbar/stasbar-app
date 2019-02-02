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
import com.stasbar.app.database.PostgresDatabase
import com.stasbar.app.goodreads.GoodreadsApi
import com.stasbar.app.goodreads.GoodreadsService
import com.stasbar.app.googlebooks.GoogleBooksApi
import com.stasbar.app.googlebooks.GoogleBooksService
import com.stasbar.app.models.extensions.getPropertyOrDefault
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.jaxb.JaxbConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.URI

val testCommonModule = module {
  single<OkHttpClient> {
    OkHttpClient.Builder()
      .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
      .build()
  }

  single<BooksDatabase> {
    val (dbUri, username, password)
      = parseDatabaseCredentials(getProperty("DATABASE_URL"), getProperty("ENV"))

    PostgresDatabase(4, dbUri, username, password)
  }
}

val commonModule = module {
  single<OkHttpClient> {
    OkHttpClient.Builder()
      .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
      .build()
  }

  single<BooksDatabase> {
    val (dbUri, username, password)
      = parseDatabaseCredentials(getProperty("DATABASE_URL"), getProperty("ENV"))

    PostgresDatabase(4, dbUri, username, password)
  }
}
val goodreadsModule = module {
  single<GoodreadsService> {
    Retrofit.Builder()
      .baseUrl(getPropertyOrDefault("goodreads_base_url", "https://www.goodreads.com"))
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
      .baseUrl(getPropertyOrDefault("googlebooks_base_url", "https://www.googleapis.com"))
      .client(get())
      .addConverterFactory(MoshiConverterFactory.create())
      .addCallAdapterFactory(CoroutineCallAdapterFactory())
      .build()
      .create(GoogleBooksService::class.java)
  }
  single {
    GoogleBooksApi(get(), getProperty("GOOGLEBOOKS_API_KEY"))
  }
}
val prodModules = listOf(commonModule, goodreadsModule, googleBooksModule)
val testModules = listOf(testCommonModule, goodreadsModule, googleBooksModule)

data class DatabaseCredentials(val dbUri: String, val username: String, val password: String)

fun parseDatabaseCredentials(databaseUrl: String, environment: String): DatabaseCredentials {
  val dbUrl = URI(databaseUrl)
  val username = dbUrl.userInfo?.split(":")?.getOrNull(0) ?: ""
  val password = dbUrl.userInfo?.split(":")?.getOrNull(1) ?: ""
  val address = if (dbUrl.port != -1) "${dbUrl.host}:${dbUrl.port}" else dbUrl.host
  val dbUri = StringBuilder()
    .append("jdbc:postgresql://")
    .append(address)
    .append(dbUrl.path)
    .apply {
      if (environment == "heroku")
        append("?sslmode=require")
    }.toString()
  println(dbUri)
  return DatabaseCredentials(dbUri, username, password)
}

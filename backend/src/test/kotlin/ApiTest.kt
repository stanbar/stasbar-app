package com.stasbar.app

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.stasbar.app.goodreads.GoodreadsService
import com.stasbar.app.goodreads.XML
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.jaxb.JaxbConverterFactory
import kotlin.test.fail


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
        val res = service.getAllBooks("56108604-stanislaw-baranski", "S2go8slpAA3vsJx0SPg").await()
        if (res.isSuccessful.not()) {
            fail(res.errorBody().toString())
        }
        val response = res.body()!!
        println(response)
        println(XML.stringify(response))
    }

    @Test
    fun getAllBookFromRead() = runBlocking {
        val res = service.getAllBooks(
            id = "56108604-stanislaw-baranski",
            key = "S2go8slpAA3vsJx0SPg",
            shelf = "read"
        ).await()

        if (res.isSuccessful.not()) {
            fail(res.errorBody().toString())
        }
        val response = res.body()!!
        println(response)
        println(XML.stringify(response))
    }



}
package com.stasbar.app.android.features

import com.stasbar.app.models.Book
import com.stasbar.app.models.Quote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BackendApi {
  @GET("/api/books")
  fun getBooks(@Query("shelf") shelf: String = "read"): Call<List<Book>>

  @GET("/api/quotes")
  fun getQuotes(@Query("limit") limit: Int? = null): Call<List<Quote>>
}

class BackendService(private val service: BackendApi) {
  fun getAllReadBooks() = service.getBooks()
  fun getFeaturedBooks() = service.getBooks("featured")
  fun getProgrammingBooks() = service.getBooks("programming")
  fun getAllQuotes() = service.getQuotes()
  fun getFeaturedQuotes() = service.getQuotes(10)
}

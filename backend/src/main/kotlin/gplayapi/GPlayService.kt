package com.stasbar.app.gplayapi

import com.stasbar.app.googlebooks.GoogleBooksService
import googlebooks.GoogleBooksSearchResult
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.coroutineScope
import mu.KotlinLogging
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface GoogleBooksService {
  @Headers("Accept: */*")
  @GET("/books/v1/volumes")
  fun getBookByIsbnAsync(
    @Query("q") q: String,
    @Query("key") key: String,
    @Query("default") default: Boolean = false,
    @Query("fields") fields: String = "items(volumeInfo/imageLinks)"
  ): Deferred<GoogleBooksSearchResult>
}

class GoogleBooksApi(private val service: GoogleBooksService, private val apiKey: String) {
  fun getBookByIsbn(isbn: String) = service.getBookByIsbn("isbn:$isbn", apiKey)
}

interface GPlayService {
  @GET("/api/apps/{packageName}/")
  fun getBookByIsbnAsync(
    @Path("packageName") packageName: String
  ): Deferred<AppDetails>

  @GET("/api/developers/{developerName}/")
  fun getDeveloperAppsAsync(
    @Path("developerName") developerName: String
  ): Deferred<DeveloperApps>
}

class GPlayApi(private val service: GPlayService) {
  private val logger = KotlinLogging.logger {}
  suspend fun getAppDownloads(packageName: String): AppStat {
    val response = service.getBookByIsbnAsync(packageName).await()
    return AppStat(response.minInstalls, response.score)
  }

  suspend fun getTotalDeveloperAppsDownloads(developerName: String): AppStat {
    val response = service.getDeveloperAppsAsync(developerName).await()
    val appDownloads = coroutineScope {
      response.apps.map {
        getAppDownloads(it.appId)
      }
    }
    val totalDownloads = appDownloads.sumBy { it.downloads }
    val weightedAvgScore =
      appDownloads.sumByDouble { it.downloads * it.score } /
        totalDownloads

    return AppStat(totalDownloads, weightedAvgScore)
  }
}

package com.stasbar.app.android

import android.app.Application
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.stasbar.app.android.aboutme.AboutMeViewModel
import com.stasbar.app.android.features.BackendApi
import com.stasbar.app.android.features.BackendService
import com.stasbar.app.android.features.books.BooksAdapter
import com.stasbar.app.android.features.books.GetFeaturedBooks
import com.stasbar.app.android.features.quotes.GetFeaturedQuotes
import com.stasbar.app.android.features.quotes.QuotesAdapter
import com.stasbar.app.models.extensions.getPropertyOrDefault
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

@Suppress("unused") //Manifest
class MainApplication : Application() {
  override fun onCreate() {
    super.onCreate()
    Timber.plant(Timber.DebugTree())
    startKoin {
      androidContext(this@MainApplication)
      androidFileProperties()
      modules(mainModule)
    }
  }
}

val mainModule = module {
  single<OkHttpClient> {
    OkHttpClient.Builder()
      .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
      .build()
  }
  single<BackendApi> {
    Retrofit.Builder()
      .baseUrl(getPropertyOrDefault("stasbar_base_url", "https://stasbar.com/"))
      .client(get<OkHttpClient>())
      .addConverterFactory(MoshiConverterFactory.create())
      .addCallAdapterFactory(CoroutineCallAdapterFactory())
      .build()
      .create(BackendApi::class.java)
  }
  single { BackendService(get()) }
  single { GetFeaturedBooks(get()) }
  single { GetFeaturedQuotes(get()) }
  factory { QuotesAdapter() }
  factory { BooksAdapter() }
  viewModel { AboutMeViewModel(get(), get()) }
}

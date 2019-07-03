package com.stasbar.app.android.notifications

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.stasbar.app.models.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope

class NotificationWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

  override val coroutineContext = Dispatchers.IO
  override suspend fun doWork(): Result = coroutineScope {
    val quote = getQuote()
    sendNotification(quote)
    Result.success()
  }

  fun getQuote(): Quote {
    TODO()
  }

  fun sendNotification(quote: Quote) {
    TODO()
  }

}

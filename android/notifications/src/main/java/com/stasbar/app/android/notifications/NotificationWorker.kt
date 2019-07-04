package com.stasbar.app.android.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.stasbar.app.android.features.BackendService
import com.stasbar.app.models.Quote
import com.stasbar.core.functional.Either
import com.stasbar.core.interactor.UseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject

class NotificationWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params), KoinComponent,
  CoroutineScope {

  private val backendService: BackendService by inject()
  private val getGoldenNugget = GetGoldenNugget(backendService)

  override suspend fun doWork(): Result = withContext(Dispatchers.IO) {
    val quote = getQuote() ?: return@withContext Result.failure()
    sendNotification(quote)

    Result.success()
  }

  private suspend fun getQuote(): Quote? {
    val result = getGoldenNugget.run(UseCase.None)

    return if (result.isSuccess)
      (result as Either.Success).a
    else null
  }

  private fun sendNotification(quote: Quote) {
    createNotificationChannel()
    val builder =
      NotificationCompat.Builder(applicationContext, applicationContext.getString(R.string.golden_nuggets_channel_id))
        .setSmallIcon(com.stasbar.app.android.R.drawable.ic_launcher_foreground)
        .setContentTitle(applicationContext.getString(R.string.golden_nugget))
        .setContentText(quote.text)
        .setAutoCancel(true)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    NotificationManagerCompat.from(applicationContext).notify(GOLDEN_NUGGET_NOTIFICATION_ID, builder.build())
  }

  private fun createNotificationChannel() {
    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is new and not in the support library
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val name = applicationContext.getString(R.string.golden_nugget_channel_name)
      val descriptionText =
        applicationContext.getString(R.string.golden_nugget_channel_description)
      val importance = NotificationManager.IMPORTANCE_DEFAULT
      val channel =
        NotificationChannel(applicationContext.getString(R.string.golden_nuggets_channel_id), name, importance).apply {
          description = descriptionText
        }
      // Register the channel with the system
      val notificationManager: NotificationManager =
        applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
      notificationManager.createNotificationChannel(channel)
    }
  }

  companion object {
    const val GOLDEN_NUGGET_NOTIFICATION_ID = 100
  }
}

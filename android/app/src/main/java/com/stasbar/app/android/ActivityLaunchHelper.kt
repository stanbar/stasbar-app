package com.stasbar.app.android

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import com.google.android.instantapps.InstantApps
import timber.log.Timber

object ActivityLaunchHelper {
  private const val URL_BASE = "https://stasbar.com"
  private const val URL_ME = "$URL_BASE/me"
  private const val URL_BOOKS = "$URL_BASE/books"
  private const val URL_QUOTES = "$URL_BASE/quotes"
  private const val URL_NOTIFICATIONS = "$URL_BASE/notifications"


  fun launchMe(activity: Activity, options: ActivityOptionsCompat?) {
    val starter = meIntent(activity)
    if (options == null)
      activity.startActivity(starter)
    else
      ActivityCompat.startActivity(activity, starter, options.toBundle())
  }

  fun launchBooks(activity: Activity, options: ActivityOptionsCompat?) {
    val starter = booksIntent(activity)
    if (options == null)
      activity.startActivity(starter)
    else
      ActivityCompat.startActivity(activity, starter, options.toBundle())
  }

  fun launchQuotes(activity: Activity, options: ActivityOptionsCompat?) {
    val starter = quotesIntent(activity)
    if (options == null)
      activity.startActivity(starter)
    else
      ActivityCompat.startActivity(activity, starter, options.toBundle())
  }

  fun launchNotifications(activity: Activity, options: ActivityOptionsCompat?) {
    if (InstantApps.isInstantApp(activity)) {
      Timber.d("This is instant app")
      InstantApps.showInstallPrompt(activity, notificationsIntent(activity), 100, null)
    } else {
      Timber.d("This is installed app, launching directly")
      val starter = notificationsIntent(activity)
      if (options == null)
        activity.startActivity(starter)
      else
        ActivityCompat.startActivity(activity, starter, options.toBundle())
    }
  }

  fun booksIntent(context: Context?) = baseIntent(URL_BOOKS, context)
  fun meIntent(context: Context?) = baseIntent(URL_ME, context)
  fun notificationsIntent(context: Context?) = baseIntent(URL_NOTIFICATIONS, context)
  fun quotesIntent(context: Context?) = baseIntent(URL_QUOTES, context)


  private fun baseIntent(url: String, context: Context? = null): Intent {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
      .addCategory(Intent.CATEGORY_DEFAULT)
      .addCategory(Intent.CATEGORY_BROWSABLE)
    if (context != null) intent.`package` = context.packageName
    return intent
  }

}

package com.stasbar.app.android.notifications

import android.content.SharedPreferences
import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.timePicker
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class NotificationsFragment : PreferenceFragmentCompat() {

  private val timeFormatter = SimpleDateFormat("hh:mm")
  private val sharedPreferences: SharedPreferences by lazy { PreferenceManager.getDefaultSharedPreferences(context) }
  override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
    setPreferencesFromResource(R.xml.notification_preferences, rootKey)


    findPreference<Preference>(getString(R.string.enable_notifications_key))?.setOnPreferenceChangeListener { preference, newValue ->
      refreshRecurringWork()
      true
    }


    findPreference<Preference>(getString(R.string.notification_time_key))?.setOnPreferenceClickListener { preference ->
      MaterialDialog(context!!).show {
        timePicker { dialog, time ->
          sharedPreferences.edit()
            .putString(getString(R.string.notification_time_key), timeFormatter.format(time.time))
            .apply()
          refreshRecurringWork()
        }
      }
      true
    }
  }

  private fun refreshRecurringWork() {
    val enabled = sharedPreferences.getBoolean(getString(R.string.enable_notifications_key), false)

    if (!enabled) {
      WorkManager.getInstance(context!!).cancelUniqueWork("golden_nuggets_notification")
      return
    }
    val timeFormatted = sharedPreferences.getString(getString(R.string.notification_time_key), "09:00")
    val time = timeFormatter.parse(timeFormatted)
    val notificationCalendar = Calendar.getInstance()
    notificationCalendar.time = time

    val initialDelayMuinutes = calculateInitialDelayMinutes(notificationCalendar)

    val sendNotification = PeriodicWorkRequestBuilder<NotificationWorker>(1, TimeUnit.DAYS)
      .setInitialDelay(initialDelayMuinutes.toLong(), TimeUnit.MINUTES)
      .build()

    WorkManager.getInstance(context!!)
      .enqueueUniquePeriodicWork("golden_nuggets_notification", ExistingPeriodicWorkPolicy.REPLACE, sendNotification)

  }

  private fun calculateInitialDelayMinutes(target: Calendar): Int {
    val now = Calendar.getInstance()
    val nowTimeInMinutes = now.get(Calendar.HOUR_OF_DAY) * 60 + now.get(Calendar.MINUTE)
    val targetTimeInMinutes = target.get(Calendar.HOUR_OF_DAY) * 60 + target.get(Calendar.MINUTE)

    return if (targetTimeInMinutes >= nowTimeInMinutes)
      targetTimeInMinutes - nowTimeInMinutes
    else
      24 * 60 - nowTimeInMinutes + targetTimeInMinutes
  }
}

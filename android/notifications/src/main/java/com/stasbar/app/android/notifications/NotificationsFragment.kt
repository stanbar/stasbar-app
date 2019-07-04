package com.stasbar.app.android.notifications

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.datetime.timePicker
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class NotificationsFragment : PreferenceFragmentCompat() {

  private val timeFormatter = SimpleDateFormat("HH:mm")
  private val sharedPreferences: SharedPreferences by lazy { PreferenceManager.getDefaultSharedPreferences(context) }
  override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
    setPreferencesFromResource(R.xml.notification_preferences, rootKey)

    findPreference<Preference>(getString(R.string.enable_notifications_key))?.setOnPreferenceChangeListener { preference, newValue ->
      refreshRecurringWork(newValue as Boolean, targetTime())
      true
    }
    findPreference<Preference>(getString(R.string.notification_time_key))?.summary =
      timeFormatter.format(targetTime().time)

    findPreference<Preference>(getString(R.string.notification_time_key))?.setOnPreferenceClickListener { preference ->
      MaterialDialog(context!!).show {
        cornerRadius(16f)

        timePicker(targetTime()) { dialog, time ->
          sharedPreferences.edit().putCalendar(getString(R.string.notification_time_key), time).apply()
          preference.summary = timeFormatter.format(time.time)
          val enabled = sharedPreferences.getBoolean(getString(R.string.enable_notifications_key), false)
          refreshRecurringWork(enabled, time)
        }
      }
      true
    }
  }

  private fun targetTime() =
    sharedPreferences.getCalendar(
      getString(R.string.notification_time_key),
      timeFormatter.parse("09:00").toCalendar()
    )

  private fun refreshRecurringWork(enabled: Boolean, targetTime: Calendar) {
    val workName = getString(R.string.golden_nugget_notification_work_name)

    if (!enabled) {
      GlobalScope.launch {
        WorkManager.getInstance(context!!).cancelUniqueWork(workName).result.get()
        Timber.d("Successfully canceled work $workName")
      }
      return
    }

    val initialDelayMinutes = calculateInitialDelayMinutes(targetTime)

    val sendNotification = PeriodicWorkRequestBuilder<NotificationWorker>(1, TimeUnit.DAYS)
      .setInitialDelay(initialDelayMinutes.toLong(), TimeUnit.MINUTES)
      .build()

    WorkManager.getInstance(context!!)
      .enqueueUniquePeriodicWork(workName, ExistingPeriodicWorkPolicy.REPLACE, sendNotification)

    Toast.makeText(
      context,
      "You will receive daily golden nugget at ${timeFormatter.format(targetTime.time)}",
      Toast.LENGTH_LONG
    ).show()

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

  private fun SharedPreferences.getCalendar(key: String, defaultValue: Calendar): Calendar {
    val timeFormatted = getString(key, null)
    return if (timeFormatted != null)
      timeFormatter.parse(timeFormatted).toCalendar()
    else
      defaultValue
  }

  private fun SharedPreferences.Editor.putCalendar(key: String, value: Calendar): SharedPreferences.Editor {
    return putString(key, timeFormatter.format(value.time))
  }

  private fun Date.toCalendar(): Calendar {
    val cal = Calendar.getInstance()
    cal.time = this
    return cal
  }
}

package com.stasbar.app.android.notifications

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class NotificationsFragment : PreferenceFragmentCompat() {
  override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
    setPreferencesFromResource(R.xml.notification_preferences, rootKey)
  }

}

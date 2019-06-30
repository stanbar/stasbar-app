package com.stasbar.app.android.notifications

import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import com.stasbar.app.android.core.platform.BaseActivity

class NotificationsActivity : BaseActivity() {
  override val selfMenuItemId = com.stasbar.app.android.R.id.navigation_notifications
  override val navigationView by lazy { findViewById<NavigationView>(R.id.navigationView) }

  override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(R.layout.activity_notifications)
    super.onCreate(savedInstanceState)

    supportFragmentManager
      .beginTransaction()
      .replace(R.id.notification_container, NotificationsFragment())
      .commit()
  }
}

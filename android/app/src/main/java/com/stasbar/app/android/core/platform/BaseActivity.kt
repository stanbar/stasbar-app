package com.stasbar.app.android.core.platform

import android.os.Bundle
import androidx.annotation.MenuRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.stasbar.app.android.ActivityLaunchHelper
import com.stasbar.app.android.R

abstract class BaseActivity : AppCompatActivity() {
  protected abstract val selfMenuItemId: Int
  protected open val navigationView: NavigationView by lazy { findViewById<NavigationView>(R.id.navigationView) }
  protected val appLinkActionby by lazy { intent.action }
  protected val appLinkData by lazy { intent.data }
  val drawerLayout by lazy { findViewById<DrawerLayout>(R.id.drawerLayout) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    navigationView.setNavigationItemSelectedListener {
      if (it.itemId == selfMenuItemId) {
        false
      } else {
        goToNavDrawerItem(it.itemId)
        true
      }
    }
  }

  private fun goToNavDrawerItem(@MenuRes item: Int) {
    when (item) {
      R.id.navigation_aboutme -> ActivityLaunchHelper.launchMe(this, null)
      R.id.navigation_books -> ActivityLaunchHelper.launchBooks(this, null)
      R.id.navigation_quotes -> ActivityLaunchHelper.launchQuotes(this, null)
      R.id.navigation_notifications -> ActivityLaunchHelper.launchNotifications(this, null)
    }
    finish()
  }

  override fun onBackPressed() {
    if (drawerLayout.isDrawerOpen(GravityCompat.START))
      drawerLayout.closeDrawer(GravityCompat.START)
    else
      super.onBackPressed()
  }
}

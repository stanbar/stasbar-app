package com.stasbar.app.android.core.extenstion

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context.browse(url: String) {
  val urlIntent = Intent(Intent.ACTION_VIEW)
  urlIntent.data = Uri.parse(url)
  startActivity(urlIntent)
}

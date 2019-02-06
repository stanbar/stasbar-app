package com.stasbar.app.android.core.extenstion

import android.content.res.Resources
import android.util.DisplayMetrics

val Int.pxToDp: Int
  get() = (this / Resources.getSystem().displayMetrics.density).toInt()
val Int.dpToPx: Int
  get() = (this * Resources.getSystem().displayMetrics.density).toInt()

fun Int.dpToPx(displayMetrics: DisplayMetrics): Int = (this * displayMetrics.density).toInt()

fun Int.pxToDp(displayMetrics: DisplayMetrics): Int = (this / displayMetrics.density).toInt()

package com.stasbar.app.android.core.extensions

import android.util.DisplayMetrics
import kotlin.math.roundToInt

fun Int.toDp(displayMetrics: DisplayMetrics): Float = this.toFloat() / displayMetrics.density
fun Int.toSp(displayMetrics: DisplayMetrics): Float = this.toFloat() / displayMetrics.scaledDensity
fun Float.spToPx(displayMetrics: DisplayMetrics): Int =
  (this * displayMetrics.scaledDensity).roundToInt()
fun Float.dpToPx(displayMetrics: DisplayMetrics): Int =
  (this * displayMetrics.density).roundToInt()

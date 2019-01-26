package com.stasbar.app.android.core.platform

import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.stasbar.app.android.R

@BindingAdapter("tagText")
fun TextView.setTagText(tag: String) {
  val spannable = SpannableString(tag).apply {
    setSpan(UnderlineSpan(), 0, tag.length - 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    setSpan(ForegroundColorSpan(ContextCompat.getColor(context, R.color.colorAccent)), 0, tag.length - 2, 0)
  }
  text = spannable
}

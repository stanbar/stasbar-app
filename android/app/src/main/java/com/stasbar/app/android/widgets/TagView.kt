package com.stasbar.app.android.widgets

import android.content.Context
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.util.AttributeSet
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.stasbar.app.android.R

class TagView : TextView {

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    val params = context.obtainStyledAttributes(attrs, R.styleable.TagView, 0, 0)
    val tagText = params.getString(R.styleable.TagView_tagText)
    params.recycle()
    tagText?.let { setTagText(it) }
  }

  fun setTagText(tagText: String) {
    val spannable = SpannableString(tagText).apply {
      setSpan(UnderlineSpan(), 0, tagText.length - 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
      setSpan(ForegroundColorSpan(ContextCompat.getColor(context, R.color.colorAccent)), 0, tagText.length - 2, 0)
    }
    text = spannable
  }

  constructor(context: Context) : this(context, null)
}

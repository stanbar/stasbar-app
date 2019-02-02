package com.stasbar.app.android.widgets

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.SpannableStringBuilder
import android.text.method.LinkMovementMethod
import android.text.style.ForegroundColorSpan
import android.text.style.URLSpan
import android.text.style.UnderlineSpan
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.stasbar.app.android.R


class AppView : LinearLayout {

  enum class Platform {
    MOBILE, DESKTOP
  }

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    orientation = LinearLayout.VERTICAL
    val params = context.obtainStyledAttributes(attrs, R.styleable.AppView, 0, 0)
    val name = checkNotNull(params.getString(R.styleable.AppView_name)) { "Can not be empty" }
    val description = checkNotNull(params.getString(R.styleable.AppView_description)) { "Can not be empty" }
    val image = checkNotNull(params.getDrawable(R.styleable.AppView_img)) { "Can not be empty" }
    val platform = Platform.values()[params.getInt(R.styleable.AppView_platform, Platform.MOBILE.ordinal)]
    val github = params.getString(R.styleable.AppView_github)
    val googlePlay = params.getString(R.styleable.AppView_googlePlay)
    val website = params.getString(R.styleable.AppView_website)
    val appStore = params.getString(R.styleable.AppView_appStore)
    params.recycle()
    val spann = SpannableStringBuilder(description)
    spann.append()
    if (appStore != null && googlePlay != null) {
      spann.append(". Both on ")
      spann.appendLink("Android", googlePlay)
      spann.append(" and ")
      spann.appendLink("iOS", appStore)
    } else if (googlePlay != null) {
      spann.append(". Check out on ")
      spann.appendLink("Google Play", googlePlay)
    }
    if (github != null) {
      spann.append(". Check it out on ")
      spann.appendLink("Github", github)
    }
    if (website != null) {
      spann.append(". See ")
      spann.appendLink("website", website)
    }

    LayoutInflater.from(context).inflate(R.layout.app_view, this, true)

    val tvName = getChildAt(0) as TextView
    val ivAppImage = getChildAt(1) as ImageView
    val tvDescription = getChildAt(2) as TextView
    tvName.text = name

    tvDescription.setText(spann, TextView.BufferType.SPANNABLE)
    tvDescription.movementMethod = LinkMovementMethod.getInstance()

    ivAppImage.setImageDrawable(image)
  }

  fun SpannableStringBuilder.appendLink(name: String, href: String): SpannableStringBuilder {
    val start = length
    append(name)
    val end = length
    val urlSpan = object : URLSpan(href) {
      override fun onClick(view: View) {
        val urlIntent = Intent(Intent.ACTION_VIEW)
        urlIntent.data = Uri.parse(url)
        context.startActivity(urlIntent)
      }
    }
    setSpan(urlSpan, start, end, 0)
    setSpan(UnderlineSpan(), start, end, 0)
    setSpan(ForegroundColorSpan(ContextCompat.getColor(context, R.color.textColorPrimary)), start, end, 0)
    return this
  }


  constructor(context: Context) : this(context, null)
}

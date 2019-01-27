package com.stasbar.app.android.widgets

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.SpannableString
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
    val name = params.getString(R.styleable.AppView_name)
    val description = params.getString(R.styleable.AppView_description)
    val image = params.getDrawable(R.styleable.AppView_img)
    val platform = Platform.values()[params.getInt(R.styleable.AppView_platform, 0)]
    val github = params.getString(R.styleable.AppView_github)
    val googlePlay = params.getString(R.styleable.AppView_googlePlay)
    val website = params.getString(R.styleable.AppView_website)
    val appStore = params.getString(R.styleable.AppView_appStore)
    params.recycle()
    val descriptionBuilder = StringBuilder(description)

    if (appStore != null && googlePlay != null) {
      descriptionBuilder.append(". Both on Android and iOS")
      descriptionBuilder.append(linkSpannable("Android", googlePlay))
      //TODO spannable must be set at the end of evaluation
    } else if (googlePlay != null) {
      descriptionBuilder.append(". Check out on Google Play")
    }
    if (github != null) {
      descriptionBuilder.append(". Check it out on Github")
    }
    if (website != null) {
      descriptionBuilder.append(". See website")
    }

    LayoutInflater.from(context).inflate(R.layout.app_view, this, true)
    val tvName = getChildAt(0) as TextView
    val ivAppImage = getChildAt(1) as ImageView
    val tvDescription = getChildAt(2) as TextView
    tvName.text = name

    tvDescription.text = descriptionBuilder.toString()
    tvDescription.movementMethod = LinkMovementMethod.getInstance()

    ivAppImage.setImageDrawable(image)
  }

  fun linkSpannable(name: String, href: String): SpannableString {
    return SpannableString(name).apply {
      val urlSpan = object : URLSpan(href) {
        override fun onClick(view: View) {
          val urlIntent = Intent(Intent.ACTION_VIEW)
          urlIntent.data = Uri.parse(url)
          context.startActivity(urlIntent)
        }
      }
      setSpan(urlSpan, 0, name.length, 0)
      setSpan(UnderlineSpan(), 0, name.length, 0)
      setSpan(ForegroundColorSpan(ContextCompat.getColor(context, R.color.textColorPrimary)), 0, name.length, 0)
    }

  }

  constructor(context: Context) : this(context, null)
}

package com.stasbar.app.android.widgets

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.ForegroundColorSpan
import android.text.style.URLSpan
import android.text.style.UnderlineSpan
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.flexbox.FlexboxLayout
import com.stasbar.app.android.R


class AppView : LinearLayout {

  enum class Platform {
    MOBILE, DESKTOP
  }

  val name: String
  private val description: String
  private val image: Drawable
  private val platform: Platform
  private val github: String?
  private val googlePlay: String?
  private val website: String?
  private val appStore: String?

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    orientation = LinearLayout.VERTICAL
    val params = context.obtainStyledAttributes(attrs, R.styleable.AppView, 0, 0)
    name = checkNotNull(params.getString(R.styleable.AppView_name)) { "Can not be empty" }
    description = checkNotNull(params.getString(R.styleable.AppView_description)) { "Can not be empty" }
    image = checkNotNull(params.getDrawable(R.styleable.AppView_img)) { "Can not be empty" }
    platform = Platform.values()[params.getInt(R.styleable.AppView_platform, Platform.MOBILE.ordinal)]
    github = params.getString(R.styleable.AppView_github)
    googlePlay = params.getString(R.styleable.AppView_googlePlay)
    website = params.getString(R.styleable.AppView_website)
    appStore = params.getString(R.styleable.AppView_appStore)
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

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    val lp = layoutParams as FlexboxLayout.LayoutParams
    Log.d("AppView", "${platform.name} \nFlexBasicPercent ${lp.flexBasisPercent} \nmaxWidth ${lp.maxWidth}")
//    lp.flexBasisPercent = if (platform == Platform.MOBILE) 0.5f else 1.0f
//    lp.minWidth = 200
    layoutParams = lp
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

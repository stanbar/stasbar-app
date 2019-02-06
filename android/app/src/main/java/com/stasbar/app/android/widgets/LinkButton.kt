package com.stasbar.app.android.widgets

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.net.Uri
import android.util.AttributeSet
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.button.MaterialButton
import com.stasbar.app.android.core.extenstion.dpToPx

class LinkButton : MaterialButton {

  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
    iconTintMode = PorterDuff.Mode.DST
    setOnClickListener {
      startActivity(context, Intent(Intent.ACTION_VIEW, Uri.parse(tag as String)), null)
    }
    iconSize = 20.dpToPx
  }

  constructor(context: Context, attrs: AttributeSet?) : this(
    context,
    attrs,
    com.google.android.material.R.attr.materialButtonStyle
  )

  constructor(context: Context) : this(context, null)
}

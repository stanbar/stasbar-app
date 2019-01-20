package com.stasbar.app.android.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import com.stasbar.app.android.R

class SpecView : LinearLayout {
  val tvName: TextView
  val tvDescription: TextView

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
    orientation = LinearLayout.VERTICAL
    val params = context.obtainStyledAttributes(attrs, R.styleable.SpecView, 0, 0)
    val name = params.getString(R.styleable.SpecView_name)
    val description = params.getString(R.styleable.SpecView_description)
    params.recycle()
    LayoutInflater.from(context).inflate(R.layout.spec, this, true)
    tvName = getChildAt(0) as TextView
    tvDescription = getChildAt(1) as TextView
    tvName.text = name
    tvDescription.text = description
  }

  constructor(context: Context) : this(context, null)
}

/*
 * Copyright 2019 Stanislaw stasbar Baranski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *          __             __
 *    _____/ /_____ ______/ /_  ____ ______
 *   / ___/ __/ __ `/ ___/ __ \/ __ `/ ___/
 *  (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
 * /____/\__/\__,_/____/_.___/\__,_/_/
 *            stasbar@stasbar.com
 */

package com.stasbar.app.android.aboutme

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.stasbar.app.android.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_header.*
import java.util.*


class AboutMeActivity : AppCompatActivity() {

  fun getAge(): Int {
    val current = Calendar.getInstance();
    val monthsDiff = Math.signum(current.get(Calendar.MONTH) - 3.0).toInt()
    return current.get(Calendar.YEAR) - 1995 + monthsDiff
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setLogo()
    setTags()
    setButtons()
  }

  private fun setLogo() {
    val logoText = """           __             __
     _____/ /_____ ______/ /_  ____ ______
    / ___/ __/ __ `/ ___/ __ \/ __ `/ ___/
   (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
  /____/\__/\__,_/____/_.___/\__,_/_/"""

    tvLogo.text = logoText
  }

  private fun setTags() {
    arrayOf(
      "full stack software developer, ",
      "beginner entrepreneur, ",
      "blockchain enthusiast, ",
      "b.s. computer science, ",
      "%d years old  ".format(getAge())
    ).forEach { tag ->
      val textView = layoutInflater.inflate(R.layout.text_view_tag, null) as TextView
      val text = SpannableString(tag)
      text.setSpan(UnderlineSpan(), 0, text.length - 2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
      text.setSpan(ForegroundColorSpan(ContextCompat.getColor(this, R.color.colorAccent)), 0, text.length - 2, 0)
      textView.text = text
      flexBoxTagline.addView(textView)
    }
  }

  data class LinkImageButton(
    val name: String,
    val href: String,
    val icon: Int,
    val textColor: Int,
    val backgroundColor: Int
  )

  private fun setButtons() {
    arrayOf(
      LinkImageButton(
        "LinkedIn",
        "https://www.linkedin.com/in/stasbar/",
        R.drawable.ic_linkedin,
        Color.parseColor("#243641"),
        Color.parseColor("#FFFFFF")
      ),
      LinkImageButton(
        "Github",
        "https://github.com/stasbar",
        R.drawable.ic_github,
        Color.parseColor("#FFFFFF"),
        Color.parseColor("#212529")
      ),
      LinkImageButton(
        "Keybase",
        "https://keybase.io/stasbar",
        R.drawable.ic_keybase,
        Color.parseColor("#FFFFFF"),
        Color.parseColor("#3095F4")
      ),
      LinkImageButton(
        "StackOverflow",
        "https://stackoverflow.com/story/stasbar",
        R.drawable.ic_stackoverflowicon,
        Color.parseColor("#343536"),
        Color.parseColor("#F9F9FA")
      ),
      LinkImageButton(
        "TaxLedger",
        "https://tax-ledger.com",
        R.drawable.ic_taxledger,
        Color.parseColor("#243641"),
        Color.parseColor("#FFFFFF")
      ),
      LinkImageButton(
        "VapeTool",
        "http://vapetool.stasbar.com",
        R.drawable.ic_vapetool,
        Color.parseColor("#FFFFFF"),
        Color.parseColor("#3546A7")
      )
    ).forEach {
      val button = layoutInflater.inflate(R.layout.link_image_button, null) as MaterialButton
      //button.icon = getDrawable(it.icon)
      button.setIconResource(it.icon)
      button.text = it.name
      button.setTextColor(it.textColor)
      button.iconTintMode = PorterDuff.Mode.DST
      button.backgroundTintList = ColorStateList.valueOf(it.backgroundColor)
      button.setOnClickListener { view ->
        handleLinkImageButtonClick(it)
      }
      flexBoxButtons.addView(button)
    }
  }


  private fun handleLinkImageButtonClick(button: LinkImageButton) {
    // todo analytics
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(button.href)))

  }


}


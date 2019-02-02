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
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.stasbar.app.android.R
import com.stasbar.app.android.features.books.BooksAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.best_books.*
import kotlinx.android.synthetic.main.header.*
import kotlinx.coroutines.androidx.lifecycle.coroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import java.util.*

class AboutMeActivity : AppCompatActivity() {
  private val viewModel: AboutMeViewModel by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    tvMyAge.setTagText(getString(R.string.my_age, getAge()))
    val adapter = BooksAdapter()
    rvBestBooks.adapter = adapter
    viewModel.bestBooks.observe(this, androidx.lifecycle.Observer {
      coroutineScope.launch {
        adapter.replaceAll(it)
      }
    })

    viewModel.requestBestBooks()
    setLogo()
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
      button.setOnClickListener { _ ->
        handleLinkImageButtonClick(it)
      }
      flexBoxButtons.addView(button)
    }
  }

  fun getAge(): Int {
    val current = Calendar.getInstance()
    val diff = Math.signum(current.get(Calendar.MONTH) - 3.0).toInt()
    return current.get(Calendar.YEAR) - 1995 + diff
  }

  private fun handleLinkImageButtonClick(button: LinkImageButton) {
    // todo analytics
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(button.href)))

  }


}


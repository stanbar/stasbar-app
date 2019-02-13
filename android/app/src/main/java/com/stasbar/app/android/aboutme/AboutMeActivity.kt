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

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.stasbar.app.android.R
import com.stasbar.app.android.core.extenstion.browse
import com.stasbar.app.android.core.extenstion.gone
import com.stasbar.app.android.core.extenstion.show
import com.stasbar.app.android.features.books.BooksAdapter
import com.stasbar.app.android.features.quotes.QuotesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.best_books.*
import kotlinx.android.synthetic.main.best_quotes.*
import kotlinx.android.synthetic.main.footer.*
import kotlinx.android.synthetic.main.header.*
import org.koin.android.ext.android.inject
import java.util.*

class AboutMeActivity : AppCompatActivity() {
  private val viewModel: AboutMeViewModel by inject()
  private val quotesAdapter: QuotesAdapter by inject()
  private val booksAdapter: BooksAdapter by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val appLinkIntent = intent
    val appLinkAction = appLinkIntent.action
    val appLinkData = appLinkIntent.data

    tvMyAge.setTagText(getString(R.string.my_age, getAge()))

    rvBestBooks.layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.best_books_span_count))
    rvBestBooks.adapter = booksAdapter

    rvBestQuotes.adapter = quotesAdapter

    viewModel.bestBooks.observe(this, androidx.lifecycle.Observer {
      booksAdapter.replaceAll(it)
      tvNoBestBooks.gone()

    })
    viewModel.bestBooksFailure.observe(this, androidx.lifecycle.Observer {
      tvNoBestBooks.show()
    })

    viewModel.bestQuotes.observe(this, androidx.lifecycle.Observer {
      quotesAdapter.replaceAll(it)
      tvNoBestQuotes.gone()

    })
    viewModel.bestQuotesFailure.observe(this, androidx.lifecycle.Observer {
      tvNoBestQuotes.show()
    })

    viewModel.requestBestBooks()
    viewModel.requestBestQuotes()
    setLogo()
    setFooter()
  }

  private fun setLogo() {
    val logoText = """           __             __
     _____/ /_____ ______/ /_  ____ ______
    / ___/ __/ __ `/ ___/ __ \/ __ `/ ___/
   (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
  /____/\__/\__,_/____/_.___/\__,_/_/"""

    tvLogo.text = logoText
  }

  private fun setFooter() {
    val footerSpannable = SpannableStringBuilder()
    tvFooterSourceCode.setOnClickListener {
      browse("https://github.com/stasbar/stasbar-app")
    }
    footerSpannable.append("build with ")
    footerSpannable.append("Kotlin ❤️", ForegroundColorSpan(ContextCompat.getColor(this, R.color.textColorPrimary)), 0)
    tvFooter.setText(footerSpannable, TextView.BufferType.SPANNABLE)
  }

  fun getAge(): Int {
    val current = Calendar.getInstance()
    val diff = Math.signum(current.get(Calendar.MONTH) - 3.0).toInt()
    return current.get(Calendar.YEAR) - 1995 + diff
  }

}


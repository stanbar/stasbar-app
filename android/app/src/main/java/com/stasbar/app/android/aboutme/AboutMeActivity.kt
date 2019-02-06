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
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
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
    val adapter = setupBestBooks()
    viewModel.bestBooks.observe(this, androidx.lifecycle.Observer {
      coroutineScope.launch {
        adapter.replaceAll(it)
      }
    })

    viewModel.requestBestBooks()
    setLogo()
  }

  private fun setupBestBooks(): BooksAdapter {
    val adapter = BooksAdapter()
    rvBestBooks.adapter = adapter
    rvBestBooks.layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.best_books_span_count))
    return adapter
  }

  private fun setLogo() {
    val logoText = """           __             __
     _____/ /_____ ______/ /_  ____ ______
    / ___/ __/ __ `/ ___/ __ \/ __ `/ ___/
   (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
  /____/\__/\__,_/____/_.___/\__,_/_/"""

    tvLogo.text = logoText
  }

  fun getAge(): Int {
    val current = Calendar.getInstance()
    val diff = Math.signum(current.get(Calendar.MONTH) - 3.0).toInt()
    return current.get(Calendar.YEAR) - 1995 + diff
  }

}


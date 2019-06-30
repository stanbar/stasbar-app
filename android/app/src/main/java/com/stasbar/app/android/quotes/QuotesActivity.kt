package com.stasbar.app.android.quotes

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.stasbar.app.android.R
import com.stasbar.app.android.core.extenstion.gone
import com.stasbar.app.android.core.extenstion.show
import com.stasbar.app.android.core.platform.BaseActivity
import com.stasbar.app.android.features.quotes.QuotesAdapter
import kotlinx.android.synthetic.main.content_quotes.*
import org.koin.android.ext.android.inject

class QuotesActivity : BaseActivity() {
  override val selfMenuItemId = R.id.navigation_quotes

  private val viewModel: QuotesViewModel by inject()
  private val quotesAdapter: QuotesAdapter by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(R.layout.activity_quotes)
    super.onCreate(savedInstanceState)

    rvAllQuotes.layoutManager = LinearLayoutManager(this)
    rvAllQuotes.adapter = quotesAdapter

    viewModel.allQuotes.observe(this, androidx.lifecycle.Observer {
      quotesAdapter.replaceAll(it)
      tvNoAllQuotes.gone()
    })
    viewModel.allQuotesFailure.observe(this, androidx.lifecycle.Observer {
      tvNoAllQuotes.show()
    })

    viewModel.requestAllQuotes()
  }
}

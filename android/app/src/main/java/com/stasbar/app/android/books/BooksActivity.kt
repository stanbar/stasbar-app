package com.stasbar.app.android.books

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.stasbar.app.android.R
import com.stasbar.app.android.core.extenstion.gone
import com.stasbar.app.android.core.extenstion.show
import com.stasbar.app.android.core.platform.BaseActivity
import com.stasbar.app.android.features.books.BooksAdapter
import kotlinx.android.synthetic.main.content_books.*
import org.koin.android.ext.android.inject

class BooksActivity : BaseActivity() {
  override val selfMenuItemId = R.id.navigation_books

  private val viewModel: BooksViewModel by inject()
  private val booksAdapter: BooksAdapter by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    setContentView(R.layout.activity_books)
    super.onCreate(savedInstanceState)

    rvAllBooks.layoutManager = GridLayoutManager(this, resources.getInteger(R.integer.best_books_span_count))
    rvAllBooks.adapter = booksAdapter

    viewModel.allBooks.observe(this, androidx.lifecycle.Observer {
      booksAdapter.replaceAll(it)
      tvNoAllBooks.gone()
    })
    viewModel.allBooksFailure.observe(this, androidx.lifecycle.Observer {
      tvNoAllBooks.show()
    })

    viewModel.requestAllBooks()
  }
}

package com.stasbar.app.android.aboutme

import androidx.lifecycle.MutableLiveData
import com.stasbar.app.android.core.platform.CoroutineViewModel
import com.stasbar.app.android.features.books.GetFeaturedBooks
import com.stasbar.app.android.features.quotes.GetFeaturedQuotes
import com.stasbar.app.models.Book
import com.stasbar.app.models.Quote
import com.stasbar.core.exception.Failure
import com.stasbar.core.interactor.UseCase

class AboutMeViewModel(
  private val getFeaturedBooks: GetFeaturedBooks,
  private val getFeaturedQuotes: GetFeaturedQuotes
) : CoroutineViewModel() {
  val bestBooks = MutableLiveData<List<Book>>()
  val bestBooksFailure = MutableLiveData<Failure>()

  val bestQuotes = MutableLiveData<List<Quote>>()
  val bestQuotesFailure = MutableLiveData<Failure>()

  fun requestBestBooks() {
    getFeaturedBooks.execute(
      this, UseCase.None(),
      { books -> bestBooks.value = books },
      { failure -> bestBooksFailure.value = failure })
  }

  fun requestBestQuotes() {
    getFeaturedQuotes.execute(this, UseCase.None(),
      { quotes -> bestQuotes.value = quotes },
      { failure -> bestQuotesFailure.value = failure })
  }
}

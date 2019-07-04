package com.stasbar.app.android.quotes

import androidx.lifecycle.MutableLiveData
import com.stasbar.app.android.core.platform.CoroutineViewModel
import com.stasbar.app.android.features.quotes.GetAllQuotes
import com.stasbar.app.android.features.quotes.GetFeaturedQuotes
import com.stasbar.app.models.Quote
import com.stasbar.core.exception.Failure
import com.stasbar.core.interactor.UseCase

class QuotesViewModel(
  private val getFeaturedQuotes: GetFeaturedQuotes,
  private val getAllQuotes: GetAllQuotes
) :
  CoroutineViewModel() {
  val allQuotes = MutableLiveData<List<Quote>>()
  val allQuotesFailure = MutableLiveData<Failure>()
  val bestQuotes = MutableLiveData<List<Quote>>()
  val bestQuotesFailure = MutableLiveData<Failure>()

  fun requestAllQuotes() {
    getAllQuotes.execute(
      this, UseCase.None,
      { books -> allQuotes.value = books },
      { failure -> allQuotesFailure.value = failure })
  }

  fun requestBestQuotes() {
    getFeaturedQuotes.execute(
      this, UseCase.None,
      { quotes -> bestQuotes.value = quotes },
      { failure -> bestQuotesFailure.value = failure })
  }
}

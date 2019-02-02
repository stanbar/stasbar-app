package com.stasbar.app.android.aboutme

import androidx.lifecycle.MutableLiveData
import com.stasbar.app.android.core.platform.CoroutineViewModel
import com.stasbar.app.android.features.books.GetFeaturedBooks
import com.stasbar.app.models.Book
import com.stasbar.core.exception.Failure
import com.stasbar.core.interactor.UseCase

class AboutMeViewModel(private val getBestBooks: GetFeaturedBooks) : CoroutineViewModel() {
  val bestBooks = MutableLiveData<List<Book>>()
  val bestBooksFailure = MutableLiveData<Failure>()

  fun requestBestBooks() {
    getBestBooks.execute(this, UseCase.None(),
      { books -> bestBooks.value = books },
      { failure -> bestBooksFailure.value = failure })
  }
}

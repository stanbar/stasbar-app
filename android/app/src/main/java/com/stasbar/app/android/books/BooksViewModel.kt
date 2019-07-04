package com.stasbar.app.android.books

import androidx.lifecycle.MutableLiveData
import com.stasbar.app.android.core.platform.CoroutineViewModel
import com.stasbar.app.android.features.books.GetAllBooks
import com.stasbar.app.android.features.books.GetFeaturedBooks
import com.stasbar.app.models.Book
import com.stasbar.core.exception.Failure
import com.stasbar.core.interactor.UseCase

class BooksViewModel(
  private val getFeaturedBooks: GetFeaturedBooks,
  private val getAllBooks: GetAllBooks
) :
  CoroutineViewModel() {
  val allBooks = MutableLiveData<List<Book>>()
  val allBooksFailure = MutableLiveData<Failure>()
  val bestBooks = MutableLiveData<List<Book>>()
  val bestBooksFailure = MutableLiveData<Failure>()

  fun requestAllBooks() {
    getAllBooks.execute(
      this, UseCase.None,
      { books -> allBooks.value = books },
      { failure -> allBooksFailure.value = failure })
  }

  fun requestBestBooks() {
    getFeaturedBooks.execute(
      this, UseCase.None,
      { books -> bestBooks.value = books },
      { failure -> bestBooksFailure.value = failure })
  }


}

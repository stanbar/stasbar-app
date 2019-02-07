package com.stasbar.app.android.features.books

import com.stasbar.app.android.features.BackendService
import com.stasbar.app.models.Book
import com.stasbar.core.exception.Failure
import com.stasbar.core.functional.Either
import com.stasbar.core.interactor.UseCase
import timber.log.Timber

class GetFeaturedBooks(private val backendService: BackendService) : UseCase<UseCase.None, List<Book>>() {
  override suspend fun run(params: None): Either<List<Book>, Failure> {
    val books = try {
      backendService.getFeaturedBooks().await()
    } catch (e: Exception) {
      Timber.e(e)
      return Either.Failure(Failure.ServerError)
    }
    return Either.Success(books)
  }

}

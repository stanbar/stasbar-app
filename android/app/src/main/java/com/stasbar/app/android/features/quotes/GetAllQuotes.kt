package com.stasbar.app.android.features.quotes

import com.stasbar.app.android.features.BackendService
import com.stasbar.app.models.Quote
import com.stasbar.core.exception.Failure
import com.stasbar.core.functional.Either
import com.stasbar.core.interactor.UseCase
import timber.log.Timber

class GetAllQuotes(private val backendService: BackendService) : UseCase<UseCase.None, List<Quote>>() {
  override suspend fun run(params: None): Either<List<Quote>, Failure> {
    val books = try {
      backendService.getAllQuotes().await()
    } catch (e: Exception) {
      Timber.e(e)
      return Either.Failure(Failure.ServerError)
    }
    return Either.Success(books)
  }

}

package com.stasbar.app.android.notifications

import com.stasbar.app.android.features.BackendService
import com.stasbar.app.models.Quote
import com.stasbar.core.exception.Failure
import com.stasbar.core.functional.Either
import com.stasbar.core.interactor.UseCase
import timber.log.Timber

class GetGoldenNugget(private val backendService: BackendService) : UseCase<UseCase.None, Quote>() {
  override suspend fun run(params: None): Either<Quote, Failure> {
    val goldenNugget = try {
      backendService.getGoldenNugget().await()
    } catch (e: Exception) {
      Timber.e(e)
      return Either.Failure(Failure.ServerError)
    }
    return Either.Success(goldenNugget)
  }
}

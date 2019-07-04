package com.stasbar.core.interactor

import com.stasbar.core.exception.Failure
import com.stasbar.core.functional.Either
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Created by stasbar on 19/06/2018
 */
abstract class UseCase<in Params, out Type> where Type : Any {

  abstract suspend fun run(params: Params): Either<Type, Failure>

  fun execute(
    parentScope: CoroutineScope,
    params: Params,
    onSuccess: (Type) -> Unit,
    onFailure: (Failure) -> Unit = {}
  ) {
    val job = parentScope.async(Dispatchers.IO) { run(params) }
    parentScope.launch {
      val result = job.await()
      result.either(onSuccess, onFailure)
    }
  }

  object None
}

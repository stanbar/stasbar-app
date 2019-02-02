package com.stasbar.core.functional

/**
 * Copyright (C) 2018 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Represents a value of one of two possible types (a disjoint union).
 * Instances of [Either] are either an instance of [Success] or [Failure].
 * FP Convention dictates that [Success] is used for "failure"
 * and [Failure] is used for "success".
 *
 * @see Success
 * @see Failure
 */
sealed class Either<out L, out R> {
  /** * Represents the success side of [Either] class which by convention is a "Failure". */
  data class Success<out L>(val a: L) : Either<L, Nothing>()

  /** * Represents the failure side of [Either] class which by convention is a "Success". */
  data class Failure<out R>(val b: R) : Either<Nothing, R>()

  val isFailure get() = this is Failure<R>
  val isSuccess get() = this is Success<L>

  fun <L> success(a: L) = Success(a)
  fun <R> failure(b: R) = Failure(b)

  fun either(success: (L) -> Any, failure: (R) -> Any): Any =
    when (this) {
      is Success -> success(a)
      is Failure -> failure(b)
    }
}

// Credits to Alex Hart -> https://proandroiddev.com/kotlins-nothing-type-946de7d464fb
// Composes 2 functions
fun <A, B, C> ((A) -> B).c(f: (B) -> C): (A) -> C = {
  f(this(it))
}

fun <T, L, R> Either<L, R>.flatMap(fn: (R) -> Either<L, T>): Either<L, T> =
  when (this) {
    is Either.Success -> Either.Success(a)
    is Either.Failure -> fn(b)
  }

fun <T, L, R> Either<L, R>.map(fn: (R) -> (T)): Either<L, T> = this.flatMap(fn.c(::failure))

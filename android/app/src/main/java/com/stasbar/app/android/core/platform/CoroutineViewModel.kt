package com.stasbar.app.android.core.platform

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlin.coroutines.CoroutineContext


abstract class CoroutineViewModel : ViewModel(), CoroutineScope {
  private val job = SupervisorJob()
  override val coroutineContext: CoroutineContext
    get() = job + Dispatchers.Main

  @CallSuper
  override fun onCleared() {
    super.onCleared()
    job.cancelChildren()
  }
}

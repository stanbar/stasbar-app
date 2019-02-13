package com.stasbar

import com.stasbar.app.di.testModules
import org.junit.After
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest

abstract class BaseKoinTest : KoinTest {
  @Before
  open fun setUp() {
    startKoin {
      modules(testModules)
      environmentProperties()
      fileProperties()
    }
  }

  @After
  open fun tearDown() {
    stopKoin()
  }
}

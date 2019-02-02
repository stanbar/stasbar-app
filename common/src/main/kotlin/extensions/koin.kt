package com.stasbar.app.models.extensions

import org.koin.core.definition.DefinitionContext
import org.koin.core.error.MissingPropertyException

fun <T> DefinitionContext.getPropertyOrDefault(key: String, defaultValue: T): T {
  return try {
    getProperty(key)
  } catch (e: MissingPropertyException) {
    defaultValue
  }
}

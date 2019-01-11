/*
 * Copyright 2019 Stanislaw stasbar Baranski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *          __             __
 *    _____/ /_____ ______/ /_  ____ ______
 *   / ___/ __/ __ `/ ___/ __ \/ __ `/ ___/
 *  (__  ) /_/ /_/ (__  ) /_/ / /_/ / /
 * /____/\__/\__,_/____/_.___/\__,_/_/
 *            stasbar@stasbar.com
 */

package com.stasbar.app

import mu.KotlinLogging
import java.io.IOException
import java.util.*


object Config {
  private val props = Properties()
  private val logger = KotlinLogging.logger {}

  init {
    val properties = javaClass.getResourceAsStream("/api.properties")
    try {
      props.load(properties)
    } catch (e: IOException) {
      logger.error("Failed to load properties from /api.properties file")
    }
  }

  val GOODREADS_API_KEY: String = props.getProperty("GOODREADS_API_KEY")
  val GOODREADS_USER_ID: String = props.getProperty("GOODREADS_USER_ID")
  val DATABASE_USER: String = props.getProperty("DATABASE_USER")
  val DATABASE_PASSWORD: String = props.getProperty("DATABASE_PASSWORD")

}
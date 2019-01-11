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

import com.fasterxml.jackson.databind.SerializationFeature
import com.stasbar.app.di.goodreadsModule
import com.stasbar.app.goodreads.GoodreadsRepository
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CallLogging
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.html.respondHtml
import io.ktor.jackson.jackson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.route
import io.ktor.routing.routing
import kotlinx.html.*
import mu.KotlinLogging
import org.koin.core.KoinProperties
import org.koin.ktor.ext.inject
import org.koin.ktor.ext.installKoin

fun main(args: Array<String>) = io.ktor.server.netty.EngineMain.main(args)
private val logger = KotlinLogging.logger {}
@Suppress("unused") // Referenced in application.conf
fun Application.module() {
  installKoin(listOf(goodreadsModule), KoinProperties(useKoinPropertiesFile = true))
  install(DefaultHeaders)
  install(CallLogging)
  install(ContentNegotiation) {
    jackson {
      enable(SerializationFeature.INDENT_OUTPUT)
    }
  }

  val goodreadsRepository: GoodreadsRepository by inject()

  // Registers routes
  routing {
    get("/") {
      call.respondHtml {
        head {
          title { +"Ktor on Google App Engine Standard" }
        }
        body {
          p { +"Hello there! This is Ktor running on Google Appengine Standard" }
          ul {
            li {
              a(href = "/api/fetchGoodreads") { +"Fetch Goodreads" }
            }
            li {
              a(href = "/api/quotes") { +"Quotes" }
            }
            li {
              a(href = "/api/books") { +"Books" }
            }
          }
        }
      }
    }
    route("/api") {
      get("/fetchGoodreads") {
        goodreadsRepository.fetchAllBooks()
        goodreadsRepository.fetchAllQuotes()
        call.respond("OK")
      }
      get("/quotes") {
        call.respond(goodreadsRepository.getAllQuotes())
      }
      get("/books") {
        val books = goodreadsRepository.getAllBooks()
        logger.info("queried ${books.size} books")
        call.respond(books)
      }
    }
  }
}


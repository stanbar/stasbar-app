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

package com.stasbar.app.models

import org.apache.commons.codec.digest.DigestUtils
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Quotes : Table() {
  val hash = varchar("hash", 32).primaryKey()
  val text = text("text")
  val author = varchar("author", 64)
  val position = integer("position")
  val bookHash = (varchar("bookHash", 32) references Books.hash).nullable()
}

fun ResultRow.toQuote(books: List<Shelf>) = Quote(
  text = get(Quotes.text),
  author = get(Quotes.author),
  position = get(Quotes.position),
  book = if (hasValue(Books.rating) && this.tryGet(Books.rating) != null) toBook(books) else null
)

data class Quote(
  val text: String,
  val author: String,
  val position: Int,
  val book: Book? = null
) {
  val hash: String = DigestUtils.md5Hex(text)
}

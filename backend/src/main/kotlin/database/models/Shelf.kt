/*
 * Copyright 2019 Stanislaw Baranski @stasbar
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

package com.stasbar.app.database.models

import com.stasbar.app.models.Shelf
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Shelves : IntIdTable() {
  val value = varchar("value", 32)
}

fun ResultRow.toShelf() = Shelf(
  value = get(Shelves.value)
)

object BookShelves : Table() {
  val shelf = reference("shelf", Shelves)
  val book = reference("bookHash", Books.hash)
  override val primaryKey = PrimaryKey(shelf, book)
}

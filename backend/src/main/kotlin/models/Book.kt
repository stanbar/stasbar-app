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

object Books : Table() {
    val hash = varchar("hash", 32).primaryKey()
    val title = varchar("title", 256)
    val author = varchar("author", 64)
    val rating = integer("rating")
    val goodreadsId = integer("goodreadsId").nullable()
}

fun ResultRow.toBook() = Book(
    title = get(Books.title),
    rating = get(Books.rating),
    author = get(Books.author),
    goodreadsId = get(Books.goodreadsId)
)

data class Book(
    val title: String,
    val rating: Int,
    val author: String,
    //goodreads
    val goodreadsId: Int? = null,

    //nullable
    val isbn10: String? = null,
    val isbn13: String? = null,
    val description: String? = null,
    val uri: String? = null,


    val imageUrl: String? = null,
    val smallImageUrl: String? = null,
    val largeImageUrl: String? = null
) {
    val hash: String = DigestUtils.md5Hex(title + author)
}
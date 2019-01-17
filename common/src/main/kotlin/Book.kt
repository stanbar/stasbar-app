package com.stasbar.app.models

import org.apache.commons.codec.digest.DigestUtils

data class Book(
  val title: String,
  val rating: Int,
  val author: String,
  val isbn10: String? = null,
  val isbn13: String? = null,

  val goodreadsId: Int? = null,
  val imageUrl: String,
  val smallImageUrl: String,
  val shelves: List<Shelf>
) {
  val hash: String = DigestUtils.md5Hex(title + author)
}

package com.stasbar.app.models

import org.apache.commons.codec.digest.DigestUtils

data class Quote(
  val text: String,
  val author: String,
  val position: Int,
  val book: Book? = null
) {
  val hash: String = DigestUtils.md5Hex(text)
}

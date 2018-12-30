package com.stasbar.app.models

data class Author(
    val id: String,
    val name: String,
    val goodreadsLink: String?,
    val imageUrl: String?,
    val smallImageUrl: String?
)
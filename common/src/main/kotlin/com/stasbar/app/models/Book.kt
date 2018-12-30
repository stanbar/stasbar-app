package com.stasbar.app.models

data class Book(
    val id: String,
    val isbn10: String?,
    val isbn13: String?,
    val title : String,
    val goodreadsUri : String?,
    val description : String?,
    val rating : Int,
    val imageUrl : String?,
    val smallImageUrl : String?,
    val largeImageUrl : String?,
    val authors : List<Author>
)
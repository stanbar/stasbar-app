package com.stasbar.app

import java.util.*

object Config {
    private val props = Properties()

    init {
        val properties = javaClass.getResourceAsStream("/api.properties")
        props.load(properties)
    }

    val GOODREADS_API_KEY: String = props.getProperty("GOODREADS_API_KEY")

}
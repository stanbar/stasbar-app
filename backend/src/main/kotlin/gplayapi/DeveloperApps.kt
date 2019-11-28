package com.stasbar.app.gplayapi

// Generated with https://www.json2kotlin.com/
class DeveloperApps(
  val devId: String,
  val apps: List<App>
)

// Generated with https://www.json2kotlin.com/
data class App(
  val title: String,
  val appId: String,
  val url: String,
  val icon: String,
  val developer: Developer,
  val developerId: String,
  val priceText: String,
  val free: Boolean,
  val summary: String,
  val scoreText: Double,
  val score: Double,
  val playstoreUrl: String,
  val permissions: String,
  val similar: String,
  val reviews: String
)

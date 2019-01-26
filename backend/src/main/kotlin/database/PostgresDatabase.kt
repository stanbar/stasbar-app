package com.stasbar.app.database


class PostgresDatabase(poolSize: Int, jdbcConnectionUrl: String, username: String, password: String) :
  DatabaseImpl(poolSize, "org.postgresql.Driver", jdbcConnectionUrl, username, password)

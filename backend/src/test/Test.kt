import java.net.URI

fun main() {
  printJdbc(URI("postgres://login:password@host:5432/dbname"))
  printJdbc(URI("postgres://localhost/stasbarapp-test"))
  printJdbc(URI("postgres://stasbar@localhost/stasbarapp-test"))
}

private fun printJdbc(dbUri: URI) {
  val username = dbUri.userInfo?.split(":")?.getOrNull(0) ?: ""
  val password = dbUri.userInfo?.split(":")?.getOrNull(1) ?: ""
  val address = if (dbUri.port != -1) "${dbUri.host}:${dbUri.port}" else dbUri.host
  val dbUrl = "jdbc:postgresql://$address${dbUri.path}?sslmode=require"

  println("username=\"$username\" \npassword=\"$password\" \ndbUri=$dbUrl")
}

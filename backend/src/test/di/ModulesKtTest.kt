package di

import com.stasbar.app.di.parseDatabaseCredentials
import org.junit.Assert.assertEquals
import org.junit.Test

class ModulesKtTest {

  @Test
  fun `test parseDatabaseCredentials`() {
    val actual1 = parseDatabaseCredentials("postgres://login:password@host:5432/dbname", "heroku")
    assertEquals("jdbc:postgresql://host:5432/dbname?sslmode=require", actual1.dbUri)
    assertEquals("login", actual1.username)
    assertEquals("password", actual1.password)

    val actual2 = parseDatabaseCredentials("postgres://localhost/stasbarapp-test", "local")
    assertEquals("jdbc:postgresql://localhost/stasbarapp-test", actual2.dbUri)
    assertEquals("", actual2.username)
    assertEquals("", actual2.password)

    val actual3 = parseDatabaseCredentials("postgres://stasbar@localhost/stasbarapp-test", "local")
    assertEquals("jdbc:postgresql://localhost/stasbarapp-test", actual3.dbUri)
    assertEquals("stasbar", actual3.username)
    assertEquals("", actual3.password)
  }
}

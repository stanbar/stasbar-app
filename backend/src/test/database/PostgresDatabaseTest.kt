package database

import com.stasbar.BaseKoinTest
import com.stasbar.app.database.BooksDatabase
import com.stasbar.app.database.models.BookShelves
import com.stasbar.app.database.models.Books
import com.stasbar.app.database.models.Quotes
import com.stasbar.app.database.models.Shelves
import com.stasbar.app.models.Book
import com.stasbar.app.models.Quote
import com.stasbar.app.models.Shelf
import kotlinx.coroutines.runBlocking
import org.jetbrains.exposed.sql.deleteAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.Before
import org.junit.Test
import org.koin.test.inject
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PostgresDatabaseTest : BaseKoinTest() {
  private val database: BooksDatabase by inject()

  @Before
  override fun setUp() {
    super.setUp()
    database
    transaction {
      Quotes.deleteAll()
      BookShelves.deleteAll()
      Shelves.deleteAll()
      Books.deleteAll()
    }
  }

  private val the7HabitsBook = Book(
    title = "The 7 Habits of Highly Effective People: Powerful Lessons in Personal Change",
    author = "Stephen R. Covey",
    rating = 5,
    imageUrl = "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png",
    smallImageUrl = "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png",
    shelves = listOf(Shelf("read"), Shelf("favorite"))
  )

  private val the7HabitsQuote = Quote(
    text = "Most people do not listen with the intent to understand; they listen with the intent to reply",
    author = "Stephen R. Covey",
    book = the7HabitsBook,
    position = 1
  )
  private val theOneThingBook = Book(
    title = "The One Thing",
    author = "Gary Keller",
    rating = 5,
    imageUrl = "https://s.gr-assets.com/assets/nophoto/book/111x148-bcc042a9c91a29c1d680899eff700a03.png",
    smallImageUrl = "https://s.gr-assets.com/assets/nophoto/book/50x75-a91bf249278a81aabab721ef782c4a74.png",
    shelves = listOf(Shelf("read"))
  )

  private val theOneThingBookQuote = Quote(
    text = "the majority of what you want will come from the minority of what you do",
    author = "Gary Keller",
    book = theOneThingBook,
    position = 2

  )

  @Test
  fun `get all books`() = runBlocking<Unit> {
    assertTrue(database.getAllBooks().isEmpty())

    database.insertOrUpdateBooks(listOf(the7HabitsBook))
    assertEquals(1, database.getAllBooks().size)

    database.insertOrUpdateBooks(listOf(the7HabitsBook))
    assertEquals(1, database.getAllBooks().size)
  }

  @Test
  fun `get all quotes`() = runBlocking<Unit> {
    assertTrue(database.getAllQuotes(-1).isEmpty())

    database.insertOrUpdateQuotes(listOf(the7HabitsQuote))
    assertEquals(1, database.getAllQuotes(-1).size)

    database.insertOrUpdateQuotes(listOf(the7HabitsQuote))
    assertEquals(1, database.getAllQuotes(-1).size)
  }

  @Test
  fun `insert book`() = runBlocking<Unit> {
    database.insertOrUpdateBooks(listOf(the7HabitsBook))
    val actual = database.getAllBooks()[0]

    assertEquals(the7HabitsBook, actual)
  }

  @Test
  fun `insert quote`() = runBlocking<Unit> {
    //database.insertBook(the7HabitsBook)
    assertTrue(database.getAllQuotes(-1).isEmpty())
    database.insertOrUpdateQuotes(listOf(the7HabitsQuote))

    assertEquals(1, database.getAllQuotes(-1).size)
    val actual = database.getAllQuotes(-1)[0]

    assertEquals(the7HabitsQuote.text, actual.text)
    assertEquals(the7HabitsQuote.author, actual.author)
    assertEquals(the7HabitsQuote.hash, actual.hash)
  }

  @Test
  fun `insert quote connected to book`() = runBlocking<Unit> {
    database.insertOrUpdateBooks(listOf(the7HabitsBook))
    assertTrue(database.getAllQuotes(-1).isEmpty())

    database.insertOrUpdateQuotes(listOf(the7HabitsQuote))
    assertEquals(1, database.getAllQuotes(-1).size)

    val actual = database.getAllQuotes(-1)[0]
    assertEquals(the7HabitsQuote, actual)
  }

  @Test
  fun `add books in batch`() = runBlocking<Unit> {
    val books = listOf(the7HabitsBook, theOneThingBook)
    database.insertOrUpdateBooks(books)
    assertEquals(books, database.getAllBooks())
  }

  @Test
  fun `add quotes in batch`() = runBlocking<Unit> {
    val books = listOf(the7HabitsBook, theOneThingBook)
    database.insertOrUpdateBooks(books)
    val quotes = listOf(the7HabitsQuote, theOneThingBookQuote)
    database.insertOrUpdateQuotes(quotes)
    assertEquals(quotes, database.getAllQuotes(-1))
  }

  @Test
  fun `update book`() = runBlocking<Unit> {
    val books = listOf(the7HabitsBook, theOneThingBook)
    database.insertOrUpdateBooks(books)
    database.insertOrUpdateBooks(books)
    assertEquals(books, database.getAllBooks())
  }


  @Test
  fun `get read books`() = runBlocking<Unit> {
    val books = listOf(the7HabitsBook, theOneThingBook)
    database.insertOrUpdateBooks(books)
    val readBooks = database.getBooksFromShelf("read")
    assertEquals(readBooks.size, 2)
    val favBooks = database.getBooksFromShelf("favorite")
    assertEquals(favBooks.size, 1)
  }
}

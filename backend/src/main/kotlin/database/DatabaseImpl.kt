package com.stasbar.app.database

import com.stasbar.app.database.models.*
import com.stasbar.app.models.Book
import com.stasbar.app.models.Quote
import com.stasbar.app.models.Shelf
import kotlinx.coroutines.ExecutorCoroutineDispatcher
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import mu.KotlinLogging
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.concurrent.Executors

abstract class DatabaseImpl(
  poolSize: Int,
  driver: String,
  jdbcConnectionUrl: String,
  username: String,
  password: String
) : BooksDatabase {
  private val logger = KotlinLogging.logger { }
  private val dispatcher: ExecutorCoroutineDispatcher = Executors.newFixedThreadPool(poolSize).asCoroutineDispatcher()

  init {
    logger.info("Using JDBC Url: $jdbcConnectionUrl username $username")
    Database.connect(
      jdbcConnectionUrl,
      driver,
      username,
      password
    )
    transaction {
      SchemaUtils.create(Books, Quotes, Shelves, BookShelves)
    }
  }

  override suspend fun getAllBooks(): List<Book> = withContext(dispatcher) {
    transaction {
      (Books).selectAll()
        .map {
          it.toBook(runBlocking { getBookShelves(it[Books.hash]) })
        }
    }
  }

  override suspend fun insertOrUpdateBooks(books: List<Book>) {
    withContext(dispatcher) {
      transaction {
        books.forEach { book ->
          if (book.shelves.isEmpty())
            throw IllegalStateException("Book must belong to at least one shelf")

          if (Books.select { Books.hash eq book.hash }.firstOrNull() == null) {
            insertBook(book)
          } else {
            updateBook(book)
          }
        }
      }
    }
  }


  private fun insertBook(book: Book) {
    logger.debug("about to insert $book")
    Books.insert {
      it[Books.hash] = book.hash
      it[Books.title] = book.title
      it[Books.rating] = book.rating
      it[Books.goodreadsId] = book.goodreadsId
      it[Books.author] = book.author
      it[Books.isbn10] = book.isbn10
      it[Books.isbn13] = book.isbn13
      it[Books.imageUrl] = book.imageUrl
      it[Books.smallImageUrl] = book.smallImageUrl
    }
    book.shelves.forEach { shelf ->
      val shelfId = Shelves.insert {
        it[Shelves.value] = shelf.value
      } get Shelves.id

      BookShelves.insert {
        it[BookShelves.shelf] = shelfId
        it[BookShelves.book] = book.hash
      }
    }
  }

  private fun updateBook(book: Book) {
    logger.debug("about to update $book")
    Books.update({ Books.hash eq book.hash }) {
      it[Books.title] = book.title
      it[Books.rating] = book.rating
      it[Books.goodreadsId] = book.goodreadsId
      it[Books.author] = book.author
      it[Books.isbn10] = book.isbn10
      it[Books.isbn13] = book.isbn13
      it[Books.imageUrl] = book.imageUrl
      it[Books.smallImageUrl] = book.smallImageUrl
    }

    BookShelves.deleteWhere { BookShelves.book eq book.hash }

    book.shelves.forEach { shelf ->
      val shelfId = Shelves.insert {
        it[Shelves.value] = shelf.value
      } get Shelves.id

      BookShelves.insert {
        it[BookShelves.shelf] = shelfId
        it[BookShelves.book] = book.hash
      }
    }
  }

  override suspend fun getBooksFromShelf(shelf: String): List<Book> = withContext(dispatcher) {
    transaction {
      (BookShelves innerJoin Shelves innerJoin Books).select { Shelves.value eq shelf }
        .map { it.toBook(runBlocking { getBookShelves(it[Books.hash]) }) }
    }
  }

  private suspend fun getBookShelves(bookHash: String): List<Shelf> = withContext(dispatcher) {
    transaction {
      (BookShelves innerJoin Shelves innerJoin Books).select { Books.hash eq bookHash }
        .map { it.toShelf() }
    }
  }

  /**
   * Quotes
   */

  override suspend fun getAllQuotes(limit: Int): List<Quote> = withContext(dispatcher) {
    transaction {
      (Quotes leftJoin Books).selectAll()
        .also {
          if (limit != -1) it.limit(limit)
        }
        .sortedBy { Quotes.position }
        .also { println("selected ${it.count()} quotes") }
        .map {
          it.toQuote(runBlocking { getBookShelves(it[Books.hash]) })
        }
    }
  }

  override suspend fun insertOrUpdateQuotes(quotes: List<Quote>) {
    withContext(dispatcher) {
      transaction {
        quotes.forEach { quote ->
          val book = quote.book?.let {
            Books
              .select {
                (Books.hash eq it.hash) or (Books.title like it.title)
              }
              .firstOrNull()
              ?.toBook(runBlocking { getBookShelves(it.hash) })
          }
          if (Quotes.select { Quotes.hash eq quote.hash }.firstOrNull() == null) {
            insertQuote(quote, book)
          } else {
            updateQuote(quote, book)
          }
        }
      }
    }
  }

  private fun updateQuote(quote: Quote, book: Book?) {
    logger.debug("about to update quote $quote")
    logger.debug("with book $book")

    Quotes.update({ Quotes.hash eq quote.hash }) {
      it[text] = quote.text
      it[author] = quote.author
      it[position] = quote.position
      it[bookHash] = book?.hash
    }
  }

  private fun insertQuote(quote: Quote, book: Book?) {
    logger.debug("about to insert quote $quote")
    logger.debug("with book $book")
    Quotes.insert {
      it[hash] = quote.hash
      it[text] = quote.text
      it[author] = quote.author
      it[position] = quote.position
      it[bookHash] = book?.hash
    }
  }

}

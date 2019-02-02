package com.stasbar.app.android.features.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stasbar.app.android.R
import com.stasbar.app.models.Book

class BooksAdapter : RecyclerView.Adapter<BooksAdapter.BookVH>() {
  private val list = mutableListOf<Book>()

  fun addBooks(books: List<Book>) {
    val prevSize = list.size
    list.addAll(books)
    notifyItemRangeInserted(prevSize, books.size)
  }

  fun addBook(book: Book) {
    list.add(book)
    notifyItemInserted(list.size - 1)
  }

  fun replaceAll(books: List<Book>) {
    list.clear()
    list.addAll(books)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookVH {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.book_view_holder, null, false)
    return BookVH(view)
  }

  override fun getItemCount() = list.size

  override fun onBindViewHolder(holder: BookVH, position: Int) {
    holder.bind(list[position])
  }

  class BookVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    private val tvAuthor: TextView = itemView.findViewById(R.id.tvAuthor)
    private val ivBook: ImageView = itemView.findViewById(R.id.ivBook)
    fun bind(book: Book) {
      tvTitle.text = book.title
      tvAuthor.text = book.author
      Picasso.get().load(book.imageUrl).into(ivBook)
    }
  }
}


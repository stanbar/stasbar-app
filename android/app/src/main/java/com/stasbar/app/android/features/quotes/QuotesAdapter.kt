package com.stasbar.app.android.features.quotes

import android.graphics.Typeface
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.View
import android.widget.TextView
import com.stasbar.app.android.R
import com.stasbar.app.android.core.platform.ItemsAdapter
import com.stasbar.app.models.Quote

class QuotesAdapter() : ItemsAdapter<Quote, QuotesAdapter.QuoteVH>(QuoteVH::class, R.layout.quote_view_holder) {

  class QuoteVH(itemView: View) : ItemViewHolder<Quote>(itemView) {

    private val tvQuoteText: TextView = itemView.findViewById(R.id.tvQuoteText)

    override fun bind(item: Quote) {
      tvQuoteText.text = SpannableString("${item.text} ~${item.author}").apply {
        setSpan(StyleSpan(Typeface.ITALIC), 0, item.text.length, 0)
      }
    }
  }
}

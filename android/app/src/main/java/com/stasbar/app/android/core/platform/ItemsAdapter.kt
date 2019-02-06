package com.stasbar.app.android.core.platform

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlin.reflect.KClass

abstract class ItemsAdapter<T, VH : ItemsAdapter.ItemViewHolder<T>>(private val clazz: KClass<VH>, @LayoutRes val layoutVHRes: Int) :
  RecyclerView.Adapter<VH>() {
  private val items = mutableListOf<T>()

  fun replaceAll(newItems: List<T>) {
    items.clear()
    items.addAll(newItems)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
    val view = LayoutInflater.from(parent.context).inflate(layoutVHRes, null)
    return clazz.java.getConstructor(View::class.java).newInstance(view)
  }

  override fun getItemCount() = items.size

  override fun onBindViewHolder(holder: VH, position: Int) {
    holder.bind(items[position])
  }


  abstract class ItemViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
  }
}

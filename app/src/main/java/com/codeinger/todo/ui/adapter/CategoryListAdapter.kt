package com.codeinger.todo.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.codeinger.todo.data.model.Category
import com.codeinger.todo.databinding.CategoryllistBinding
import com.codeinger.todo.ui.main.KeepActivity
import kotlinx.android.synthetic.main.categoryllist.view.*

class CategoryListAdapter : RecyclerView.Adapter<CategoryListAdapter.CategoryListAdapter_View>() {
  private var categorylist = emptyList <Category>()
    class CategoryListAdapter_View(val itemView: CategoryllistBinding) : RecyclerView.ViewHolder(itemView.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListAdapter_View {
        val binding = CategoryllistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryListAdapter_View (binding)
    }

    override fun onBindViewHolder(holder: CategoryListAdapter_View, position: Int) {
        val currentItem = categorylist[position]

        holder.itemView.name.text=currentItem.name
        holder.itemView.description.text=currentItem.description

        holder.itemView.ll_item.setOnClickListener {
            val intent = Intent(holder.itemView.context, KeepActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {

        return categorylist.size
    }
}
package com.codeinger.todo.ui.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.codeinger.todo.R
import com.codeinger.todo.data.model.Category
import com.codeinger.todo.databinding.CategoryllistBinding
import kotlinx.android.synthetic.main.categoryllist.view.*

class CategoryListAdapter(
    val delete: (Category)->Unit,
    val update: (Category)->Unit ): RecyclerView.Adapter<CategoryListAdapter.CategoryListAdapter_View>() {
    private var categorylist = emptyList<Category>()

    class CategoryListAdapter_View(val itemView: CategoryllistBinding) :
        RecyclerView.ViewHolder(itemView.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListAdapter_View {
        val binding =
            CategoryllistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryListAdapter_View(binding)
    }

    override fun onBindViewHolder(holder: CategoryListAdapter_View, position: Int) {
        val currentItem = categorylist[position]

        holder.itemView.name.text = currentItem.name
        holder.itemView.description.text = currentItem.description
        holder.itemView.options.setOnClickListener {
            showPopUpMenu(it, position)
        }

        holder.itemView.ll_item.setOnClickListener {
//            val intent = Intent(holder.itemView.context, KeepActivity::class.java)
//            holder.itemView.context.startActivity(intent)
        }
    }




    fun showPopUpMenu(view: View?, position: Int) {
        val currentitem: Category = categorylist.get(position)
        val popupMenu = PopupMenu(view?.context, view)
        popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.menuDelete -> {
                    val alertDialogBuilder =
                        AlertDialog.Builder(view?.context, R.style.AppTheme_Dialog)
                    alertDialogBuilder.setTitle("Confirmation")
                        .setMessage("Are you sure you want to delete this category")
                        .setPositiveButton("Yes") { dialog, which ->
                            delete(currentitem)
                        }
                        .setNegativeButton("No") { dialog, which -> dialog.cancel() }.show()
                }
                R.id.menuUpdate -> {
                    update(currentitem)
                }
             }
            false
        }
        popupMenu.show()
    }


    override fun getItemCount(): Int {

        return categorylist.size
    }

    fun setData(category: List<Category>) {
        this.categorylist = category
        notifyDataSetChanged()

    }
}
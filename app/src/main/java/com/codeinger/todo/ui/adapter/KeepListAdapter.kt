package com.codeinger.todo.ui.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.codeinger.todo.R
import com.codeinger.todo.data.model.Keep
import com.codeinger.todo.databinding.KeeplistBinding
import kotlinx.android.synthetic.main.categoryllist.view.*
import kotlinx.android.synthetic.main.keeplist.view.*
import java.text.SimpleDateFormat

class KeepListAdapter(val delete: (Keep)->Unit,
                      val update : (Keep)->Unit): RecyclerView.Adapter<KeepListAdapter.KeepListAdapter_View>() {

    private var  keeplist = emptyList<Keep>()
   class KeepListAdapter_View(val binding: KeeplistBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeepListAdapter_View {
        val binding = KeeplistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KeepListAdapter_View(binding)
    }

    override fun onBindViewHolder(holder: KeepListAdapter_View, position: Int) {
        val currentItem = keeplist[position]

        holder.binding.title.text = currentItem.title
        holder.binding.description.text = currentItem.description


        holder.binding.date.text= SimpleDateFormat("E").format(currentItem.date.time)
        holder.binding.month.text=SimpleDateFormat("MMM").format(currentItem.date.time)
        holder.binding.day.text=SimpleDateFormat("dd").format(currentItem.date.time)
        holder.binding.time.text=SimpleDateFormat("HH:mm").format(currentItem.date.time)
        holder.binding.Event.text=currentItem.event

        holder.binding.options.setOnClickListener {
            showPopUpMenu(it, position)
        }

    }

    fun showPopUpMenu(view: View?, position: Int) {
        val currentitem: Keep = keeplist.get(position)
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
    return keeplist.size

    }

      fun setData(keep:List<Keep>){
        this.keeplist = keep
        notifyDataSetChanged()
    }
}
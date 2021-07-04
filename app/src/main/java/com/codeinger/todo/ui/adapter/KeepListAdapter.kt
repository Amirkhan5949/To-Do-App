package com.codeinger.todo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.codeinger.todo.data.model.Keep
import com.codeinger.todo.databinding.CategoryllistBinding
import com.codeinger.todo.databinding.KeeplistBinding

class KeepListAdapter : RecyclerView.Adapter<KeepListAdapter.KeepListAdapter_View>() {

    private var  keeplist = emptyList<Keep>()
   class KeepListAdapter_View(val itemView: KeeplistBinding) : RecyclerView.ViewHolder(itemView.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KeepListAdapter_View {
        val binding = KeeplistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return KeepListAdapter_View(binding)
    }

    override fun onBindViewHolder(holder: KeepListAdapter_View, position: Int) {
    }

    override fun getItemCount(): Int {
    return keeplist.size

    }
}
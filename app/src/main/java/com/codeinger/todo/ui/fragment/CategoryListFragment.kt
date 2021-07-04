package com.codeinger.todo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinger.todo.R
import com.codeinger.todo.databinding.FragmentCategoryListBinding
import com.codeinger.todo.ui.adapter.CategoryListAdapter


class CategoryListFragment : Fragment() {

    private lateinit var binding: FragmentCategoryListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding= FragmentCategoryListBinding.inflate(layoutInflater, container, false)

        val adapter =CategoryListAdapter()

        binding.rvCatList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCatList.adapter = adapter

        return binding.root
    }


}
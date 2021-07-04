package com.codeinger.todo.ui.fragment.keep

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinger.todo.R
import com.codeinger.todo.databinding.FragmentKeepListBinding
import com.codeinger.todo.ui.adapter.CategoryListAdapter
import com.codeinger.todo.ui.adapter.KeepListAdapter


class KeepListFragment : Fragment() {

    private lateinit var binding: FragmentKeepListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentKeepListBinding.inflate(layoutInflater, container, false)



        val adapter = KeepListAdapter()

        binding.rvKeep.layoutManager = LinearLayoutManager(requireContext())
        binding.rvKeep.adapter = adapter




        return binding.root
    }

}
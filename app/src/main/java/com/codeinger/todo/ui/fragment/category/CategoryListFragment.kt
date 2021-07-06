package com.codeinger.todo.ui.fragment.category

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinger.todo.data.viewmodel.CategoryViewmodel
import com.codeinger.todo.databinding.FragmentCategoryListBinding
import com.codeinger.todo.ui.adapter.CategoryListAdapter
import com.codeinger.todo.ui.fragment.category.AddCategoryFragment
import com.codeinger.todo.ui.main.CategoryActivity
import com.codeinger.todo.uitls.Type
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryListFragment : Fragment() {

    private val catViewModel : CategoryViewmodel by viewModels()
    private lateinit var binding: FragmentCategoryListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         binding= FragmentCategoryListBinding.inflate(layoutInflater, container, false)

        (activity as CategoryActivity).setAddVisiblity(View.VISIBLE)


        val adapter =CategoryListAdapter({delete->
            catViewModel.deleteCategory(delete)
        },{update->
            Log.i("csxfddfd", "onCreateView: ")
             (activity as CategoryActivity).replaceFragment(AddCategoryFragment.newInstance(Type.UPDATE,update),"AddCategoryFragment")

        })

        binding.rvCatList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCatList.adapter = adapter


        catViewModel.readAllData.observe(viewLifecycleOwner,{

            adapter.setData(it)
        })

        return binding.root
    }




}
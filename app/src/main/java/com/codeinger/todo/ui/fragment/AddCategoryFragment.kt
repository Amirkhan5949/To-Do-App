package com.codeinger.todo.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import com.codeinger.todo.R
import com.codeinger.todo.data.viewmodel.CategoryViewmodel
import com.codeinger.todo.databinding.FragmentAddCategoryBinding
import com.codeinger.todo.ui.main.CategoryActivity


class AddCategoryFragment : Fragment() {
    private lateinit var binding: FragmentAddCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        (activity as CategoryActivity).setAddVisiblity(View.GONE)
//        (activity as CategoryActivity).back()
        binding= FragmentAddCategoryBinding.inflate(layoutInflater, container, false)





        return binding.root
    }




}
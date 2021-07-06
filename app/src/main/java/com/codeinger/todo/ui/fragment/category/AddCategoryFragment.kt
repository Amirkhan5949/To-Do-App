package com.codeinger.todo.ui.fragment.category

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.codeinger.todo.data.model.Category
import com.codeinger.todo.data.viewmodel.CategoryViewmodel
import com.codeinger.todo.databinding.FragmentAddCategoryBinding
import com.codeinger.todo.ui.main.CategoryActivity
import com.codeinger.todo.ui.main.KeepActivity
import com.codeinger.todo.uitls.Type
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddCategoryFragment : Fragment() {

    private lateinit var binding: FragmentAddCategoryBinding
    private val catViewModel : CategoryViewmodel by viewModels()


    companion object {
        private const val TYPE = "type"
        private const val CATEGORY = "User"


        fun newInstance(type: Type, category: Category?): AddCategoryFragment {
            val bundle = Bundle()
            bundle.putSerializable(TYPE, type)
            bundle.putParcelable(CATEGORY, category)
            val fragment = AddCategoryFragment()
            fragment.arguments = bundle
            return fragment
        }
    }


    private var type = Type.ADD
    private var category : Category?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        (activity as CategoryActivity).setAddVisiblity(View.GONE)
//        (activity as CategoryActivity).back()
        binding= FragmentAddCategoryBinding.inflate(layoutInflater, container, false)


        init()

        binding.btnDone.setOnClickListener {
            insertAndUpdateData()
        }

        binding.back.setOnClickListener {
            (activity as CategoryActivity).back()
        }

        return binding.root
    }

    private fun init() {

        type = arguments?.getSerializable(TYPE) as Type

        if (type==Type.UPDATE){
            category= arguments?.getParcelable<Category>(CATEGORY)

            binding.etName.setText(category?.name)
            binding.etDescription.setText(category?.description)
            binding.btnDone?.setText("Update")

        }

    }

    private fun insertAndUpdateData() {


        lifecycleScope.launch {

            val name = binding.etName.text.toString()
            val description = binding.etDescription.text.toString()

            if (inputCheck(name, description)){
                binding.progressBar.visibility=View.VISIBLE
                if(type == Type.ADD){
                    val category = Category(0,name,description)
                    catViewModel.insertCategory(category)
                    Toast.makeText(requireContext(), "Successfully Added", Toast.LENGTH_LONG).show()
                }
                else{
                    val category = Category(category?.Cid!!,name,description)
                    catViewModel.updateCategory(category)
                    Toast.makeText(requireContext(), "Successfully Updated", Toast.LENGTH_LONG)
                        .show()
                }
                (activity as CategoryActivity).setAddVisiblity(View.VISIBLE)
                (activity as CategoryActivity).back()



            }
            else {
                Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG)
                    .show()
            }
         }
    }


    private fun inputCheck(name: String, description: String): Boolean {
        return (name.isNotEmpty() && description.isNotEmpty())
    }


}
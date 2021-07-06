package com.codeinger.todo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.codeinger.todo.R
import com.codeinger.todo.databinding.ActivityMainBinding
import com.codeinger.todo.ui.fragment.category.AddCategoryFragment
import com.codeinger.todo.ui.fragment.category.CategoryListFragment
import com.codeinger.todo.uitls.Type
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(CategoryListFragment(),"CategoryListFragment")


        binding.llAddCategory.setOnClickListener {
             replaceFragment(AddCategoryFragment.newInstance(Type.ADD,null),"AddCategoryFragment")

        }

    }

    fun setAddVisiblity(visibility: Int){
        binding.llAddCategory.visibility = visibility
    }

    fun back() {
        onBackPressed()
    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, fragment, tag).addToBackStack("").commit()
    }

}
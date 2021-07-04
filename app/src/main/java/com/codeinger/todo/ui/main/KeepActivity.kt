package com.codeinger.todo.ui.main

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.codeinger.todo.R
import com.codeinger.todo.databinding.ActivityKeepBinding
import com.codeinger.todo.ui.fragment.keep.AddKeepFragment
import com.codeinger.todo.ui.fragment.keep.KeepListFragment

class KeepActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeepBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityKeepBinding.inflate(layoutInflater)
        setContentView(binding.root)

      replaceFragment(KeepListFragment(),"KeepListFragment")


        binding.llAddKeep.setOnClickListener {
            replaceFragment(AddKeepFragment(),"AddKeepFragment")

        }



    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, fragment, tag).addToBackStack("").commit()
    }
}
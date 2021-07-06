package com.codeinger.todo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.codeinger.todo.R
import com.codeinger.todo.databinding.ActivityKeepBinding
import com.codeinger.todo.ui.fragment.keep.AddKeepFragment
import com.codeinger.todo.ui.fragment.keep.KeepListFragment
import com.codeinger.todo.uitls.Type
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KeepActivity : AppCompatActivity() {

   private   var  Cid = 0
    private lateinit var binding: ActivityKeepBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityKeepBinding.inflate(layoutInflater)
        setContentView(binding.root)

      replaceFragment(KeepListFragment(),"KeepListFragment")


        binding.llAddKeep.setOnClickListener {
            replaceFragment(AddKeepFragment.newInstance(Type.ADD,null,Cid),"AddKeepFragment")

        }

        Cid =intent.getIntExtra("Cid",0)


    }

    fun back(){
        onBackPressed()
    }

    fun Setvisibility(visibility : Int  ){
        binding.llAddKeep.visibility=visibility
    }

    fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, fragment, tag).addToBackStack("").commit()
    }
}
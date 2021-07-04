package com.codeinger.todo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codeinger.todo.R
import com.codeinger.todo.databinding.ActivityKeepBinding

class KeepActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeepBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityKeepBinding.inflate(layoutInflater)
        setContentView(binding.root)





    }
}
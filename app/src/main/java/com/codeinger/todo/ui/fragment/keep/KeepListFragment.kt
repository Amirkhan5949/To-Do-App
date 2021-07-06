package com.codeinger.todo.ui.fragment.keep

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.codeinger.todo.data.viewmodel.KeepViewModel
import com.codeinger.todo.databinding.FragmentKeepListBinding
import com.codeinger.todo.ui.adapter.KeepListAdapter
import com.codeinger.todo.ui.main.CategoryActivity
import com.codeinger.todo.ui.main.KeepActivity
import com.codeinger.todo.uitls.Type
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_add_keep.*

@AndroidEntryPoint
class KeepListFragment : Fragment() {

    private val keepViewModel: KeepViewModel by viewModels()

    private lateinit var binding: FragmentKeepListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKeepListBinding.inflate(layoutInflater, container, false)

        (activity as KeepActivity).Setvisibility(View.VISIBLE)

        val adapter = KeepListAdapter({ delete ->
            keepViewModel.deleteKeep(delete)
        }, { update ->
            (activity as KeepActivity).replaceFragment(
                AddKeepFragment.newInstance(
                    Type.UPDATE, update, update.Cid
                ), "AddKeepFragment"
            )
        })

        keepViewModel.readAllData.observe(viewLifecycleOwner, {
            adapter.setData(it)
        })

        binding.back.setOnClickListener {
//            (activity as CategoryActivity).back()
            val intent = Intent(binding.back.context, CategoryActivity::class.java)
            (binding.back.context.startActivity(intent))
        }


        binding.rvKeep.layoutManager = LinearLayoutManager(requireContext())
        binding.rvKeep.adapter = adapter


        return binding.root
    }

}
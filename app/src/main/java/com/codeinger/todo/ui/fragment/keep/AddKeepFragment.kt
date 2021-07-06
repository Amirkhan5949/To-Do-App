package com.codeinger.todo.ui.fragment.keep


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.codeinger.todo.data.model.Keep
import com.codeinger.todo.data.viewmodel.KeepViewModel
import com.codeinger.todo.databinding.FragmentAddKeepBinding
import com.codeinger.todo.ui.main.KeepActivity
import com.codeinger.todo.uitls.Type
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*


@AndroidEntryPoint
class AddKeepFragment : Fragment() {

    companion object {
        private const val TYPE = "type"
        private const val KEEP = "Keep"
        private const val CID = "Cid"

        fun newInstance(type: Type, keep: Keep?, Cid: Int?): AddKeepFragment {
            val bundle = Bundle()
            bundle.putSerializable(TYPE, type)
            bundle.putParcelable(KEEP, keep)
            bundle.putInt(CID, Cid!!)
            val fragment = AddKeepFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    private var type = Type.ADD

    private var keep: Keep? = null
    private var Cid: Int = 0

    private val keepViewModel: KeepViewModel by viewModels()
    private lateinit var binding: FragmentAddKeepBinding

    private val selectedDateTime = Calendar.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddKeepBinding.inflate(layoutInflater, container, false)
        (activity as KeepActivity).Setvisibility(View.GONE)

        binding.addKeep.setOnClickListener {
            insertAndUpdateData()
        }

        binding.back.setOnClickListener {
            (activity as KeepActivity).back()
        }

        val picker =
            MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(12)
                .setMinute(10)
                .build()

        binding.keepTime.setOnClickListener {
            picker.show(childFragmentManager, "tag")
        }



        picker.addOnPositiveButtonClickListener {
            // call back code
            selectedDateTime.set(Calendar.HOUR_OF_DAY,picker.hour)
            selectedDateTime.set(Calendar.MINUTE,picker.minute)


            binding.keepTime.text = SimpleDateFormat("HH:mm").format(selectedDateTime.time)
        }


        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .build()


        binding.keepDate.setOnClickListener {
            datePicker.show(childFragmentManager, "tag")
        }

        datePicker.addOnPositiveButtonClickListener {
            selectedDateTime.timeInMillis = it
            binding.keepDate.text = SimpleDateFormat("E, dd MMM").format(selectedDateTime.time)
        }

        init()

        return binding.root
    }

    private fun init() {

        type = arguments?.getSerializable(TYPE) as Type
        Cid = arguments?.getInt(CID, 0)!!

        if (type == Type.UPDATE) {
            keep = arguments?.getParcelable<Keep>(KEEP)

            binding.etTitle.setText(keep?.title)
            binding.etDescription.setText(keep?.description)
            binding.keepDate.setText(SimpleDateFormat("E, dd MMM").format(keep?.date?.time))
            binding.keepTime.setText(SimpleDateFormat("HH:mm").format(keep?.date?.time))

             binding.keepEvent.setText(keep?.event)

        }


    }

    private fun insertAndUpdateData() {

        lifecycleScope.launch {

            val keepName = binding.etTitle.text.toString()
            val description = binding.etDescription.text.toString()
            val date = binding.keepDate.text.toString()
            val time = binding.keepTime.text.toString()
            val event = binding.keepEvent.text.toString()


            if (inputcheck(keepName, description, date, time, event)) {
                binding.progressBar.visibility = View.VISIBLE

                if (type == Type.ADD) {
                    val keep = Keep(0, keepName, description, event, selectedDateTime,Cid)
                    keepViewModel.addKeep(keep)
                    Toast.makeText(requireContext(), "SuccessFully Keep Added", Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility == View.GONE
                } else {
                    val keep = Keep(keep?.Kid!!, keepName, description, event, selectedDateTime,Cid)
                    keepViewModel.updateKeep(keep)
                    binding.addKeep.text = "Update Keep"
                    binding.progressBar.visibility == View.GONE

                }

                (activity as KeepActivity).Setvisibility(View.VISIBLE)
                (activity as KeepActivity).back()


            } else {
                Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG)
                    .show()

            }
        }

    }

    private fun inputcheck(
        keepName: String,
        description: String,
        date: String,
        time: String,
        event: String
    ): Boolean {

        return (keepName.isNotEmpty() && description.isNotEmpty()
                && date.isNotEmpty() && time.isNotEmpty() && event.isNotEmpty())

    }


}
package com.example.resultactcal

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.resultactcal.databinding.FragmentCreateTaskBinding


class CreateTaskFragment : Fragment(R.layout.fragment_create_task) {
    lateinit var binding: FragmentCreateTaskBinding
    private val taskViewModel: TaskViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCreateTaskBinding.bind(view)
        binding.apply {
            lifecycleOwner = this@CreateTaskFragment
            taskViewModelXML = taskViewModel
            buttonCreateTask.setOnClickListener {
                when {
                    radioButtonToDo.isChecked -> taskViewModel.setStatusToDo()
                    radioButtonDoing.isChecked -> taskViewModel.setStatusDoing()
                    radioButtonDone.isChecked -> taskViewModel.setStatusDone()
                }
                Toast.makeText(requireContext(), taskViewModel.createTask(), Toast.LENGTH_SHORT)
                    .show()

            }
        }

    }

}
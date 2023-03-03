package com.example.resultactcal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resultactcal.databinding.FragmentToDoBinding


class ToDoFragment : Fragment(R.layout.fragment_to_do) {
    lateinit var binding : FragmentToDoBinding
    private val taskViewModel: TaskViewModel by activityViewModels()
    lateinit var adapter: Adapter
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentToDoBinding.bind(view)
        adapter = Adapter(taskViewModel.getListToDo())
        recyclerView = binding.recycler
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = adapter
    }
}
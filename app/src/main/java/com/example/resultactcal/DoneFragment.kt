package com.example.resultactcal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.resultactcal.databinding.FragmentDoneBinding


class DoneFragment : Fragment(R.layout.fragment_done) {
    lateinit var binding: FragmentDoneBinding
    private val taskViewModel : TaskViewModel by activityViewModels()
    private lateinit var adapter: Adapter
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDoneBinding.bind(view)
        adapter = Adapter(taskViewModel.getListDone())
        recyclerView = binding.recycler
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = adapter
    }

}
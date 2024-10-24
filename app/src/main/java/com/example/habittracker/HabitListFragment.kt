package com.example.habittracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.habittracker.databinding.FragmentHabitListBinding
import com.example.habittracker.model.HabitDataBase

class HabitListFragment : Fragment() {
    private var _binding: FragmentHabitListBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: HabitListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentHabitListBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[HabitListViewModel::class.java]

        val application = requireNotNull(this.activity).application
        val dao = HabitDataBase.getInstance(application).habitDao
        val viewModelFactory = HabitDataBaseViewModelFactory(dao)
        val viewModel = ViewModelProvider(
            this, viewModelFactory
        ).get(HabitDataBaseViewModel::class.java)


        // Прописать ниже RecyclerView

        return view
    }

}
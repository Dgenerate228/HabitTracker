package com.example.habittracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.adapter.CalendarRecyclerAdapter
import com.example.habittracker.databinding.FragmentCalendarBinding
import java.time.Month
import java.util.Calendar
import java.util.Locale

class CalendarFragment : Fragment() {
    private var _binding: FragmentCalendarBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CalendarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val view = binding.root
        viewModel = ViewModelProvider(this)[CalendarViewModel::class.java]
        binding.calendarMonths.text = viewModel.getMonth(viewModel.month)
        getCalendarRecyclerView()

        binding.nextMonthsButton.setOnClickListener {
            viewModel.month = viewModel.nextMonth()
            getCalendarRecyclerView()
            updateScreen()
        }

        binding.previousMonthButton.setOnClickListener {
            viewModel.month = viewModel.previousMonth()
            getCalendarRecyclerView()
            updateScreen()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun getCalendarRecyclerView() {
        val recyclerView: RecyclerView = binding.calendarRecyclerView
        recyclerView.layoutManager = GridLayoutManager(context, 7)
        recyclerView.adapter = CalendarRecyclerAdapter(viewModel.getDayInMonth())
    }

    @SuppressLint("SetTextI18n")
    private fun updateScreen() {
        binding.calendarMonths.text = viewModel.getMonth(viewModel.month)
        if (viewModel.year != viewModel.yearStart) {
            binding.calendarMonths.text =
                viewModel.getMonth(viewModel.month) + " ${viewModel.year}"
        }
    }


}
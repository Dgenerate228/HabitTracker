package com.example.habittracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.habittracker.model.HabitDao

class HabitDataBaseViewModelFactory(private val dao: HabitDao): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HabitDataBaseViewModel::class.java)) {
            return HabitDataBaseViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}
package com.example.habittracker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.habittracker.model.HabitCalendarList
import com.example.habittracker.model.HabitDao
import com.example.habittracker.model.HabitType
import kotlinx.coroutines.launch

class HabitDataBaseViewModel(val dao: HabitDao) : ViewModel() {
    var newName = ""

    fun addHabit() {
        viewModelScope.launch {
            val habit = HabitCalendarList()
            val habitName = newName
            dao.insertCalendar(habit)
        }
    }
    fun addType() {
        viewModelScope.launch {
            val type = HabitType()
            val typeName = newName
            dao.insertType(type)
        }
    }
}
package com.example.habittracker

import androidx.lifecycle.ViewModel

class HabitListViewModel : ViewModel() {

    class Habits(
        val name: String = "habit_name",
        val details: String = "habit_details",
        val type: Int? = null,
    )

}
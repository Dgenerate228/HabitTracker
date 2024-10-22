package com.example.habittracker.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "habit_calendar_list")
data class HabitCalendarList(
    @PrimaryKey(autoGenerate = true)
    var habitId: Long = 0L,
    @ColumnInfo(name = "habit_name")
    var habitName: String = "",
    @ColumnInfo(name = "habit_category")
    var habitCategory: Int = 1,
    @ColumnInfo(name = "habit_info")
    var habitInfo: String = "",
    @ColumnInfo(name = "habit_done")
    var habitDone: Boolean = false
)

@Entity(tableName = "habit_list")
data class HabitList(
    @PrimaryKey(autoGenerate = true)
    var habitId: Long = 0L,
    @ColumnInfo(name = "habit_name")
    var habitName: String = "",
    @ColumnInfo(name = "habit_type")
    var habitType: Int = 1,
    @ColumnInfo(name = "habit_picture")
    var habitPicture: String = "habit.png"
)

@Entity(tableName = "habit_type")
data class HabitType(
    @PrimaryKey(autoGenerate = true)
    var habitId: Long = 0L,
    @ColumnInfo(name = "habit_name")
    var habitName: String = "",
    @ColumnInfo(name = "habit_type")
    var habitType: Int = 1
)

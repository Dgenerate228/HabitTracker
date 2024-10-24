package com.example.habittracker.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface HabitDao {

    @Insert
    suspend fun insertCalendar(habit: HabitCalendarList)

    @Update
    suspend fun updateCalendar(habit: HabitCalendarList)

    @Delete
    suspend fun deleteCalendar(habit: HabitCalendarList)

    @Query("SELECT * FROM HABIT_CALENDAR_LIST WHERE habitId = :habitId")
    fun get(habitId: Long): LiveData<HabitCalendarList>

    @Query("SELECT * FROM HABIT_CALENDAR_LIST ORDER BY habitId DESC")
    fun getAllCalendarList(): LiveData<List<HabitCalendarList>>


//    @Insert
//    suspend fun insertType(habit: HabitType)
//
//    @Update
//    suspend fun updateType(habit: HabitType)
//
//    @Delete
//    suspend fun deleteType(habit: HabitType)
//
//    @Query("SELECT * FROM HABIT_TYPE ORDER BY habitId DESC")
//    fun getAllType(): LiveData<List<HabitType>>
//
//
//    @Insert
//    suspend fun insertList(habit: HabitList)
//
//    @Update
//    suspend fun updateList(habit: HabitList)
//
//    @Delete
//    suspend fun deleteList(habit: HabitList)
//
//    @Query("SELECT * FROM HABIT_LIST ORDER BY habitId DESC")
//    fun getAllList(): LiveData<List<HabitList>>



}
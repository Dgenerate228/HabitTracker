package com.example.habittracker.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HabitCalendarList::class], version = 1, exportSchema = false)
abstract class HabitDataBase: RoomDatabase() {
    abstract val habitDao: HabitDao

    companion object{
        @Volatile
        private var INSTANCE: HabitDataBase? = null

        fun getInstance(context: Context): HabitDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        HabitDataBase::class.java,
                        "habit_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
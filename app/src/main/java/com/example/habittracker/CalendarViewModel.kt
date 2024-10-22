package com.example.habittracker

import androidx.lifecycle.ViewModel
import java.util.Calendar

class CalendarViewModel : ViewModel() {
    private val calendar: Calendar = Calendar.getInstance()
    var month = calendar.get(Calendar.MONTH)
    var year = calendar.get(Calendar.YEAR)
    val yearStart = calendar.get(Calendar.YEAR)

    class Days(val number: Int?)

    fun getMonth(month: Int): String {
        val monthList = listOf(
            "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль",
            "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
        )
        val monthTextView = monthList[month]
        return monthTextView
    }

    fun nextMonth(): Int {
        month++
        if (month > 11) {
            month = 0
            year++
        }
        return month
    }

    fun previousMonth(): Int {
        month--
        if (month < 0) {
            month = 11
            year--
        }
        return month
    }

    fun getDayInMonth(): ArrayList<Days> {
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, month)
        val days = mutableListOf<Days>()

        var dayInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        var x = 1

        while (x <= dayInMonth) {
            days.add(Days(number = x))
            x++
        }
        return days as ArrayList<Days>
    }
}
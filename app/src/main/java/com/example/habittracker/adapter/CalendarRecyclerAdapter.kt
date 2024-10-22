package com.example.habittracker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.habittracker.CalendarViewModel
import com.example.habittracker.R

class CalendarRecyclerAdapter(
    private val dayInMonth: ArrayList<CalendarViewModel.Days>,
) : RecyclerView.Adapter<CalendarRecyclerAdapter.CalendarRecyclerViewHolder>() {

    //Указываем идентификатор макета
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarRecyclerViewHolder =
        CalendarRecyclerViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: CalendarRecyclerViewHolder, position: Int) {
        val day = dayInMonth[position]
        holder.dayOfMonth.text = day.number.toString()
    }

    //Количество элементов
    override fun getItemCount(): Int {
        return dayInMonth.size
    }

    //Отвечает за отображение
    class CalendarRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var dayOfMonth: TextView = view.findViewById(R.id.cellDayText)

        companion object {
            fun inflateFrom(parent: ViewGroup): CalendarRecyclerViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.calendar_item, parent, false)
                return CalendarRecyclerViewHolder(view)
            }
        }

    }


}
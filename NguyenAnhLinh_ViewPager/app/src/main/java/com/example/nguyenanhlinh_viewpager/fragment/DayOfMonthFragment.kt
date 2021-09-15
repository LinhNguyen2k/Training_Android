package com.example.nguyenanhlinh_viewpager.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nguyenanhlinh_viewpager.adapter.CalendarAdapter
import com.example.nguyenanhlinh_viewpager.R
import kotlinx.android.synthetic.main.fragment_day_of_month.*
import kotlinx.android.synthetic.main.fragment_day_of_month.view.*
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.ArrayList

class DayOfMonthFragment : Fragment() {
    private lateinit var selectedDate: LocalDate
    lateinit var calendarAdapters: CalendarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            selectedDate = it.getSerializable("month") as LocalDate
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_day_of_month, container, false)
        selectedDate = LocalDate.now()
        view.monthYearTV.text = monthYearFromDate(selectedDate)
        val daysInMonth = daysInMonthArray(selectedDate)
        val calendarAdapter = CalendarAdapter(daysInMonth)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 7)
        view.calendarRecyclerView.layoutManager = layoutManager
        view.calendarRecyclerView.adapter = calendarAdapter
        val itemDecoration =
            DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        view.calendarRecyclerView.addItemDecoration(itemDecoration)


        return view
    }


    private fun daysInMonthArray(date: LocalDate?): ArrayList<String> {
        val daysInMonthArray = ArrayList<String>()
        val yearMonth = YearMonth.from(date)
        val daysInMonth = yearMonth.lengthOfMonth()
        val firstOfMonth = selectedDate.withDayOfMonth(1)
        val dayOfWeek = firstOfMonth.dayOfWeek.value
        for (i in 1..42) {
            if (i <= dayOfWeek || i > daysInMonth + dayOfWeek) {
                daysInMonthArray.add("")
            } else {
                daysInMonthArray.add((i - dayOfWeek).toString())
            }
        }
        return daysInMonthArray
    }

    private fun monthYearFromDate(date: LocalDate?): String {
        val formatter = DateTimeFormatter.ofPattern("MMMM yyyy")
        return date!!.format(formatter)
    }

    fun updateViewPager(newMonth: LocalDate) {
        monthYearTV.text = monthYearFromDate(newMonth)
        daysInMonthArray(newMonth)
        val daysInMonth = daysInMonthArray(selectedDate)
        val calendarAdapter = CalendarAdapter(daysInMonth)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 7)
        calendarRecyclerView.layoutManager = layoutManager
        calendarRecyclerView.adapter = calendarAdapter
    }

    fun previousMonthAction(view: View?) {
        selectedDate = selectedDate.minusMonths(1)

    }


    fun nextMonthAction(view: View?) {
        selectedDate = selectedDate.plusMonths(1)

    }

    companion object {
        @JvmStatic
        fun newInstance(month: LocalDate) =
            DayOfMonthFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("month", month)
                }
            }
    }

}
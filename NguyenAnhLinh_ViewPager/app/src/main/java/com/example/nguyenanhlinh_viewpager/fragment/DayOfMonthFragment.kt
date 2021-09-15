package com.example.nguyenanhlinh_viewpager.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nguyenanhlinh_viewpager.adapter.CalendarAdapter
import com.example.nguyenanhlinh_viewpager.R
import com.example.nguyenanhlinh_viewpager.model.DayOfMonth
import kotlinx.android.synthetic.main.fragment_day_of_month.*
import kotlinx.android.synthetic.main.fragment_day_of_month.view.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.*

class DayOfMonthFragment : Fragment() {
    private lateinit var selectedDate: LocalDate
    lateinit var calendarAdapters: CalendarAdapter
    lateinit var calendar: Calendar
    lateinit var listDayOfMonth: ArrayList<DayOfMonth>
    var start = 2
    var sdfDate = SimpleDateFormat("dd", Locale.getDefault())
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
        daysInMonthArray(selectedDate)
        calendarAdapters = CalendarAdapter(listDayOfMonth,context)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 7)
        view.calendarRecyclerView.layoutManager = layoutManager
        view.calendarRecyclerView.adapter = calendarAdapters
        val itemDecoration =
            DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        view.calendarRecyclerView.addItemDecoration(itemDecoration)

        return view
    }


    private fun daysInMonthArray(date: LocalDate?): ArrayList<DayOfMonth> {
        listDayOfMonth = ArrayList()
        val yearMonth = YearMonth.from(date)
        val daysInMonth = yearMonth.lengthOfMonth()
        val firstOfMonth = selectedDate.withDayOfMonth(1)
        val dayOfWeek = firstOfMonth.dayOfWeek.value
        var numberDayOfPreviousWeek = dayOfWeek
        var MonthLength = YearMonth.from(date?.minusMonths(1)).lengthOfMonth()
        var currentTime = LocalDate.now()
        var indexDay = 1
        for (i in 1..43) {
            if (i < dayOfWeek) {
                listDayOfMonth.add(
                    DayOfMonth(
                        (MonthLength - numberDayOfPreviousWeek + start).toString(),
                        false, false
                    )
                )
                numberDayOfPreviousWeek--
            }else if (i >= dayOfWeek && i <= daysInMonth + dayOfWeek) {
                if (i == (daysInMonth + dayOfWeek)) {
                    indexDay = 1
                } else {
                    if (indexDay == currentTime.dayOfMonth && date?.month == currentTime.month && date?.year == currentTime.year) {
                        listDayOfMonth.add(DayOfMonth(indexDay.toString(),true, true))
                    } else {
                        listDayOfMonth.add(DayOfMonth(indexDay.toString(),false,true))
                    }
                    indexDay++
                }

            } else {
                listDayOfMonth.add(DayOfMonth(indexDay.toString(),false, false))
                indexDay++
            }
        }
        return listDayOfMonth
    }

    private fun monthYearFromDate(date: LocalDate?): String {
        val formatter = DateTimeFormatter.ofPattern("MMMM yyyy")
        return date!!.format(formatter)
    }

    fun updateViewPager(newMonth: LocalDate) {
        monthYearTV.text = monthYearFromDate(newMonth)
        daysInMonthArray(newMonth)
        calendarAdapters = CalendarAdapter(listDayOfMonth,context)
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 7)
        calendarRecyclerView.layoutManager = layoutManager
        calendarRecyclerView.adapter = calendarAdapters
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
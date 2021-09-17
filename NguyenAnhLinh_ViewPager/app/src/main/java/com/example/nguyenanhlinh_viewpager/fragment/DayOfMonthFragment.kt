package com.example.nguyenanhlinh_viewpager.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
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
import kotlin.collections.ArrayList

class DayOfMonthFragment : Fragment() {
    private lateinit var selectedDate: LocalDate
    lateinit var calendarAdapters: CalendarAdapter
    var listDayOfMonth: ArrayList<DayOfMonth> = ArrayList()
    var temp = 0

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
        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(activity, 7)
        view.calendarRecyclerView.layoutManager = layoutManager
        view.calendarRecyclerView.adapter = calendarAdapters
        val itemDecoration =
            DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        view.calendarRecyclerView.addItemDecoration(itemDecoration)

        view.setting.setOnClickListener {
            var popupMenu = PopupMenu(activity, it)
            popupMenu.menuInflater.inflate(R.menu.menu, popupMenu.menu)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.mon -> {
                        changeDayOfMonth(-1)
                        view.tv_sun.text = "MOM"
                        view.tv_mon.text = "TUE"
                        view.tv_tue.text = "WED"
                        view.tv_wed.text = "THUR"
                        view.tv_thur.text = "FRI"
                        view.tv_fri.text = "SAT"
                        view.tv_sat.text = "SUN"

                    }
                    R.id.tue -> {
                        changeDayOfMonth(0)
                        view.tv_sun.text = "TUE"
                        view.tv_mon.text = "WED"
                        view.tv_tue.text = "THUR"
                        view.tv_wed.text = "FRI"
                        view.tv_thur.text = "SAT"
                        view.tv_fri.text = "SUN"
                        view.tv_sat.text = "MON"
                    }
                    R.id.wed -> {
                        changeDayOfMonth(1)
                        view.tv_sun.text = "WED"
                        view.tv_mon.text = "THUR"
                        view.tv_tue.text = "FRI"
                        view.tv_wed.text = "SAT"
                        view.tv_thur.text = "SUN"
                        view.tv_fri.text = "MON"
                        view.tv_sat.text = "TUE"
                    }
                    R.id.thur -> {
                        changeDayOfMonth(2)
                        view.tv_sun.text = "THUR"
                        view.tv_mon.text = "FRI"
                        view.tv_tue.text = "SAT"
                        view.tv_wed.text = "SUN"
                        view.tv_thur.text = "MON"
                        view.tv_fri.text = "TUE"
                        view.tv_sat.text = "WED"
                    }
                    R.id.fri -> {
                        changeDayOfMonth(3)
                        view.tv_sun.text = "FRI"
                        view.tv_mon.text = "SAT"
                        view.tv_tue.text = "SUN"
                        view.tv_wed.text = "MON"
                        view.tv_thur.text = "TUE"
                        view.tv_fri.text = "WED"
                        view.tv_sat.text = "THUR"
                    }
                    R.id.sat -> {
                        changeDayOfMonth(4)
                        view.tv_sun.text = "SAT"
                        view.tv_mon.text = "SUN"
                        view.tv_tue.text = "MON"
                        view.tv_wed.text = "TUE"
                        view.tv_thur.text = "WED"
                        view.tv_fri.text = "THUR"
                        view.tv_sat.text = "FRI"
                    }
                    R.id.sun -> {
                        changeDayOfMonth(5)
                        view.tv_sun.text = "SUN"
                        view.tv_mon.text = "MON"
                        view.tv_tue.text = "TUE"
                        view.tv_wed.text = "WED"
                        view.tv_thur.text = "THUR"
                        view.tv_fri.text = "FRI"
                        view.tv_sat.text = "SAT"
                    }
                }
                calendarAdapters.notifyDataSetChanged()
                false
            }
        }
        return view
    }


    private fun daysInMonthArray(date: LocalDate) {
        listDayOfMonth.clear()
        var firstOfMonth = date.withDayOfMonth(1)
        var dayOfWeek = firstOfMonth.dayOfWeek.value + temp
        var countWeek = dayOfWeek
        var yearMonth = YearMonth.from(date)
        var isOfMonth = yearMonth.lengthOfMonth()
        var leftMonthLength = YearMonth.from(date.minusMonths(1)).lengthOfMonth()
        var indexDay = 1

        for (i in 1..43) {
            if (i <= dayOfWeek) {
                listDayOfMonth.add(
                    DayOfMonth(
                        (leftMonthLength - countWeek + 1).toString(),
                        check = false, checkDayOfMonth = false
                    )
                )
                countWeek--
            } else if (i >= dayOfWeek && i <= isOfMonth + dayOfWeek +1 ) {
                if (i == (isOfMonth + dayOfWeek +1)) {
                    indexDay = 1
                } else {
                    listDayOfMonth.add(
                        DayOfMonth(
                            indexDay.toString(),
                            check = false,
                            checkDayOfMonth = true
                        )
                    )

                    indexDay++
                }

            } else {
                listDayOfMonth.add(
                    DayOfMonth(
                        indexDay.toString(),
                        check = false,
                        checkDayOfMonth = false
                    )
                )
                indexDay++
            }
        }
        calendarAdapters = CalendarAdapter(listDayOfMonth, context)
    }


    private fun monthYearFromDate(date: LocalDate?): String {
        val formatter = DateTimeFormatter.ofPattern("MMMM yyyy")
        return date!!.format(formatter)
    }

    fun updateViewPager(newMonth: LocalDate) {
        monthYearTV.text = monthYearFromDate(newMonth)
        daysInMonthArray(newMonth)
        calendarRecyclerView.adapter = calendarAdapters
    }


    fun changeDayOfMonth(temp: Int) {
        this.temp = temp
        daysInMonthArray(selectedDate)
        calendarRecyclerView.adapter = calendarAdapters
        calendarAdapters.notifyDataSetChanged()
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


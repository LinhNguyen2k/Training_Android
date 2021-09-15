package com.example.nguyenanhlinh_viewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

import com.example.nguyenanhlinh_viewpager.fragment.DayOfMonthFragment
import java.time.LocalDate

class ViewPagerAdapter(fragmentManager: FragmentManager, var fragList: ArrayList<DayOfMonthFragment>) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getCount(): Int {
        return 3
    }


    override fun getItem(position: Int): Fragment {
        return fragList[position]
    }


    fun setCalendar(currentMonth: LocalDate) {
        var prevMonth = currentMonth.minusMonths(1)

        var nextMonth = currentMonth.plusMonths(1)

        fragList[0].updateViewPager(prevMonth)
        fragList[1].updateViewPager(currentMonth)
        fragList[2].updateViewPager(nextMonth)

    }
}
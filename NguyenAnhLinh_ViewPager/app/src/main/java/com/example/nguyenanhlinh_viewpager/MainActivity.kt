package com.example.nguyenanhlinh_viewpager


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.example.nguyenanhlinh_viewpager.adapter.CalendarAdapter
import com.example.nguyenanhlinh_viewpager.adapter.ViewPagerAdapter
import com.example.nguyenanhlinh_viewpager.fragment.DayOfMonthFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
private const val PAGE_CENTER = 1
class MainActivity : AppCompatActivity() {
    lateinit var localDate: LocalDate
    lateinit var listFragment: ArrayList<DayOfMonthFragment>
    lateinit var pageAdapter: ViewPagerAdapter
    var intdex = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        localDate = LocalDate.now()

        listFragment = ArrayList()

        listFragment.apply {
            add(DayOfMonthFragment.newInstance(localDate.minusMonths(1)))
            add(DayOfMonthFragment.newInstance(localDate))
            add(DayOfMonthFragment.newInstance(localDate.plusMonths(1)))
        }
        pageAdapter = ViewPagerAdapter(supportFragmentManager, listFragment)
        viewPager_layout.adapter = pageAdapter
        viewPager_layout.setCurrentItem(1, false)
        viewPager_layout.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                intdex = position
            }

            override fun onPageScrollStateChanged(state: Int) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    if (intdex < PAGE_CENTER) {
                        localDate = localDate.minusMonths(1)
                    } else if (intdex > PAGE_CENTER) {
                        localDate = localDate.plusMonths(1)
                    }
                    pageAdapter.setCalendar(localDate)
                    viewPager_layout.setCurrentItem(1, false)
                }
            }

        })
    }
}
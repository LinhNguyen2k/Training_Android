package com.example.week03.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week03.R
import com.example.week03.adapter.AdapterMenu
import com.example.week03.model.InfoHomeOne
import com.example.week03.model.MenuItem
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.fragment_menu.view.*

class Menu : Fragment() {

    private var listMenuItem = getAllItem()
    private var adapterMenuItem = AdapterMenu(listMenuItem)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu, container, false)

        val layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        view.rc_menu.adapter = adapterMenuItem
        view.rc_menu.layoutManager = layoutManager

        view.img_back.setOnClickListener {
            findNavController().navigateUp()
        }
        return view
    }

    fun getAllItem(): ArrayList<MenuItem> {
        val list = ArrayList<MenuItem>()

        list.add(MenuItem("", 4, 0))
        list.add(MenuItem("Alerts", 1, R.drawable.icons_8_alarm))
        list.add(MenuItem("Predictions", 1, R.drawable.icons_8_left_and_right_arrows))
        list.add(MenuItem("Saved elements", 1, R.drawable.icons_8_pin))
        list.add(MenuItem("Remove Ads", 1, R.drawable.icons_8_no_entry))

        list.add(MenuItem("", 4, 0))
        list.add(MenuItem("Tools", 3, 0))

        list.add(MenuItem("Select Stocks", 2, R.drawable.icons_8_profit_2))
        list.add(MenuItem("Currency Exchange", 2, R.drawable.icons_8_swap))
        list.add(MenuItem("Webinar", 2, R.drawable.icons_8_video_call))
        list.add(MenuItem("Best Broker", 2, R.drawable.icons_8_rent))

        list.add(MenuItem("", 4, 0))
        list.add(MenuItem("Markets", 3, 0))

        list.add(MenuItem("Select Stocks", 2, R.drawable.icons_8_profit_2))
        list.add(MenuItem("Currency Exchange", 2, R.drawable.icons_8_swap))
        list.add(MenuItem("Webinar", 2, R.drawable.icons_8_video_call))
        list.add(MenuItem("Best Broker", 2, R.drawable.icons_8_rent))

        return list

    }
}




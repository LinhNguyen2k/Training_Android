package com.example.week03.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week03.R
import com.example.week03.adapter.AdapterHomeListOne
import com.example.week03.adapter.AdapterHomeListTwo

import com.example.week03.model.InfoHomeOne
import com.example.week03.model.InfoHomeTwo
import kotlinx.android.synthetic.main.fragment_coin.*
import kotlinx.android.synthetic.main.fragment_coin.img_notification
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.*
import kotlin.collections.ArrayList


class Home : Fragment() {
    private val listInfoHomeOne = getAllItem1()
    private val adapterHomeListOne = AdapterHomeListOne(listInfoHomeOne)
    private var listInfoHomeTwo = getAllItem2()
    private var adapterHomeListTwo = AdapterHomeListTwo(listInfoHomeTwo)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val layoutManager1 = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        view.rc_listone.adapter = adapterHomeListOne
        view.rc_listone.layoutManager = layoutManager1


        val layoutManager2 = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        view.rc_listtwo.adapter = adapterHomeListTwo
        view.rc_listtwo.layoutManager = layoutManager2
        val itemDecoration =
            DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        view.rc_listtwo.addItemDecoration(itemDecoration)


        view.tv_loadMore.setOnClickListener {
            var index = listInfoHomeTwo.size
            listInfoHomeTwo.addAll(listLoadMore(index)!!)
            adapterHomeListTwo = AdapterHomeListTwo(listInfoHomeTwo)
            val layoutManager2 = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            view.rc_listtwo.adapter = adapterHomeListTwo
            view.rc_listtwo.layoutManager = layoutManager2
            val itemDecoration =
                DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
            view.rc_listtwo.addItemDecoration(itemDecoration)


        }
        view.btn_notification.setOnClickListener {
            val rnd = Random()
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            btn_notification.background.setTint(color)
        }


        adapterHomeListTwo.setOnclickItem {
            val item = listInfoHomeTwo[it]

            val action = HomeDirections.actionHome2ToCoin(item)
            findNavController().navigate(action)
        }
        return view

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//
//        menuInflater.inflate(R.menu.menu, menu)
//
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.it_item1 ->
//        }
//
//        return super.onOptionsItemSelected(item)
//    }

    fun getAllItem1(): ArrayList<InfoHomeOne> {
        val list = ArrayList<InfoHomeOne>()

        list.add(InfoHomeOne("INDEX"))
        list.add(InfoHomeOne("SHARES"))
        list.add(InfoHomeOne("CURRENCIES"))
        list.add(InfoHomeOne("FUTURES"))
        list.add(InfoHomeOne("CRYPTO"))

        return list

    }

    fun listLoadMore(size: Int): ArrayList<InfoHomeTwo>? {
        val list = ArrayList<InfoHomeTwo>()
        for (i in (size + 1) until (size + 10)) {
            val newItem = InfoHomeTwo(
                "DOWN JONES",
                "new item at position $i",
                "10:44:45", "+203 (+1,04%)"
            )
            list.add(newItem)
        }
        return list
    }


    fun getAllItem2(): ArrayList<InfoHomeTwo> {
        val list = ArrayList<InfoHomeTwo>()
        list.add(InfoHomeTwo("DOWN JONES", "NYSE  10:44:45", "10:44:45", "+203 (+1,04%)"))
        list.add(InfoHomeTwo("DOWN JONES", "NYSE  10:44:45", "10:44:45", "+203 (+1,04%)"))
        list.add(InfoHomeTwo("DOWN JONES", "NYSE  10:44:45", "10:44:45", "+203 (+1,04%)"))
        list.add(InfoHomeTwo("DOWN JONES", "NYSE  10:44:45", "10:44:45", "+203 (+1,04%)"))
        list.add(InfoHomeTwo("DOWN JONES", "NYSE  10:44:45", "10:44:45", "+203 (+1,04%)"))
        list.add(InfoHomeTwo("DOWN JONES", "NYSE  10:44:45", "10:44:45", "+203 (+1,04%)"))
        list.add(InfoHomeTwo("DOWN JONES", "NYSE  10:44:45", "10:44:45", "+203 (+1,04%)"))
        list.add(InfoHomeTwo("DOWN JONES", "NYSE  10:44:45", "10:44:45", "+203 (+1,04%)"))
        list.add(InfoHomeTwo("DOWN JONES", "NYSE  10:44:45", "10:44:45", "+203 (+1,04%)"))
        list.add(InfoHomeTwo("DOWN JONES", "NYSE  10:44:45", "10:44:45", "+203 (+1,04%)"))
        list.add(InfoHomeTwo("DOWN JONES", "NYSE  10:44:45", "10:44:45", "+203 (+1,04%)"))
        list.add(InfoHomeTwo("DOWN JONES", "NYSE  10:44:45", "10:44:45", "+203 (+1,04%)"))

        return list

    }
}
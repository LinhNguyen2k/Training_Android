package com.example.week03.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week03.R
import com.example.week03.adapter.AdapterHomeListOne
import com.example.week03.adapter.AdapterHomeListTwo

import com.example.week03.model.InfoHomeOne
import com.example.week03.model.InfoHomeTwo
import kotlinx.android.synthetic.main.fragment_home.*


class Home : Fragment() {
        private val listInfoHomeOne = getAllItem1()
    private val adapterHomeListOne = activity?.let { AdapterHomeListOne(listInfoHomeOne, it) }
    private val listInfoHomeTwo = getAllItem2()
    private val adapterHomeListTwo = activity?.let { AdapterHomeListTwo(listInfoHomeTwo, it) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val layoutManager1 = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        rc_listone.adapter = adapterHomeListOne
        rc_listone.layoutManager = layoutManager1


        val layoutManager2 = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rc_listtwo.adapter = adapterHomeListTwo
        rc_listtwo.layoutManager = layoutManager2
        val itemDecoration =
            DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        rc_listtwo.addItemDecoration(itemDecoration)
        bottom_NVT.background = null
        Btnt_bar.background = null
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
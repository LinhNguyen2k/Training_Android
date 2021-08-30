package com.example.week03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week03.adapter.AdapterHomeListOne
import com.example.week03.adapter.AdapterHomeListTwo
import com.example.week03.model.InfoHomeOne
import com.example.week03.model.InfoHomeTwo
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    private val listInfoHomeOne = getAllItem1()
    private val adapterHomeListOne = AdapterHomeListOne(listInfoHomeOne, this)
    private val listInfoHomeTwo = getAllItem2()
    private val adapterHomeListTwo = AdapterHomeListTwo(listInfoHomeTwo, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val actionBar = supportActionBar
        actionBar!!.hide()
        val layoutManager1 = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL, false)
        rc_listone.adapter = adapterHomeListOne
        rc_listone.layoutManager = layoutManager1


        val layoutManager2 = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
        rc_listtwo.adapter = adapterHomeListTwo
        rc_listtwo.layoutManager = layoutManager2
        val itemDecoration =
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        rc_listtwo.addItemDecoration(itemDecoration)
        bottom_NVT.background = null
        Btnt_bar.background = null

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
package com.example.week03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week03.adapter.AdapterHomeListOne
import com.example.week03.model.InfoHomeOne
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    private val listInfoHomeOne =getAllItem1()
    private val adapterHomeListOne = AdapterHomeListOne(listInfoHomeOne,this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val layoutManager = LinearLayoutManager(applicationContext, RecyclerView.HORIZONTAL,false)
        rc_listone.adapter = adapterHomeListOne

        rc_listone.layoutManager = layoutManager
//        val itemDecoration=
//            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
//        rc_listone.addItemDecoration(itemDecoration)
    }

    fun getAllItem1() : ArrayList<InfoHomeOne>{

        val list = ArrayList<InfoHomeOne>()


        list.add(InfoHomeOne("INDEX"))
        list.add(InfoHomeOne("SHARES"))
        list.add(InfoHomeOne("CURRENCIES"))
        list.add(InfoHomeOne("FUTURES"))
        list.add(InfoHomeOne("CRYPTO"))

        return list

    }
}
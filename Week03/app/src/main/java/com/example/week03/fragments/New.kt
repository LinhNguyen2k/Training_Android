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
import com.example.week03.adapter.AdapterNews
import com.example.week03.model.InfoHomeOne
import kotlinx.android.synthetic.main.fragment_news.view.*


class New : Fragment() {
    private val listItemNews = getAllItem()
    private val adapterNews = AdapterNews(listItemNews)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        val layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        view.rc_news.adapter = adapterNews
        view.rc_news.layoutManager = layoutManager


        view.cv_itemNew1.setOnClickListener {
            val title = view.tv_layout1_2.text.toString()

            var action = NewDirections.actionNew1ToNewsArticle(title)
            findNavController().navigate(action)
        }

        view.view_back.setOnClickListener {
            findNavController().navigateUp()
        }

        return view
    }

    fun getAllItem(): ArrayList<InfoHomeOne> {
        val list = ArrayList<InfoHomeOne>()

        list.add(InfoHomeOne("EDITORIAL"))
        list.add(InfoHomeOne("CRYPTO NEWS"))
        list.add(InfoHomeOne("RAW MATERIAL"))
        list.add(InfoHomeOne("ECONOMICS"))
        list.add(InfoHomeOne("EDITORIAL"))

        return list

    }

}
package com.example.week03.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week03.R
import com.example.week03.adapter.AdapterNews
import com.example.week03.model.InfoHomeOne
import kotlinx.android.synthetic.main.fragment_news.view.*
import kotlinx.android.synthetic.main.fragment_news_article.view.*
import kotlinx.android.synthetic.main.fragment_news.view.view_back as view_back1

class NewsArticle : Fragment() {
    private val listItemNewsArticle = getAllItem()
    private val adapterNewsArticle = AdapterNews(listItemNewsArticle)
    private val args by navArgs<NewsArticleArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_article, container, false)
        val layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        view.rc_newsArticle.adapter = adapterNewsArticle
        view.rc_newsArticle.layoutManager = layoutManager

        view.tv_titleNew.text = args.sendTitle

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
package com.example.week03.fragments

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week03.R
import com.example.week03.adapter.AdapterCoin
import com.example.week03.adapter.AdapterHomeListOne
import com.example.week03.model.InfoHomeOne
import kotlinx.android.synthetic.main.fragment_coin.*
import kotlinx.android.synthetic.main.fragment_coin.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.*
import kotlin.collections.ArrayList

class Coin : Fragment() {
    private val listCoin = getAllItem()
    private val adapterCoin = AdapterCoin(listCoin)
    private val args: CoinArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_coin, container, false)
        if (args.sendData?.text1 == null) {
            view.tv_neo.text = "NEO INDEX"
        } else {
            view.tv_neo.text = args.sendData?.text1
        }
        val layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        view.rc_coin.adapter = adapterCoin
        view.rc_coin.layoutManager = layoutManager

        view.view_back.setOnClickListener {
            findNavController().navigateUp()
        }

        view.img_notification.setOnClickListener {
            val rnd = Random()
            val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
            img_notification.background.setTint(color)
        }

        return view
    }

    fun getAllItem(): ArrayList<InfoHomeOne> {
        val list = ArrayList<InfoHomeOne>()

        list.add(InfoHomeOne("General", false))
        list.add(InfoHomeOne("Technical Section", true))
        list.add(InfoHomeOne("Markets", false))
        list.add(InfoHomeOne("Charts", false))
        list.add(InfoHomeOne("General", false))

        return list

    }

}
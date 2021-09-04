package com.example.week03.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.chauthai.swipereveallayout.SwipeRevealLayout
import com.chauthai.swipereveallayout.ViewBinderHelper
import com.example.week03.R
import com.example.week03.model.InfoHomeTwo

class AdapterHomeListTwo(private val listInfoTwo: ArrayList<InfoHomeTwo>) :
    RecyclerView.Adapter<AdapterHomeListTwo.ViewHolder>() {
    private val viewBinderHelper = ViewBinderHelper()
    lateinit var onClickItem: (positions: Int) -> Unit

    fun setOnclickItem(even: (position: Int) -> Unit) {
        onClickItem = even
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var text1: TextView = view.findViewById(R.id.tv_one_list2)
        var text2: TextView = view.findViewById(R.id.tv_two_list2)
        var text3: TextView = view.findViewById(R.id.tv_three_list2)
        var text4: TextView = view.findViewById(R.id.tv_four_list2)
        var layout_custom: RelativeLayout = view.findViewById(R.id.layout_custom)
        var swipeRevealLayout: SwipeRevealLayout = view.findViewById(R.id.swipeRevealLayout)
        var layoutDelete: LinearLayout = view.findViewById(R.id.layoutDelete)

        init {
            layout_custom.setOnClickListener {
                onClickItem.invoke(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_home_list2, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info: InfoHomeTwo = listInfoTwo[position]

        holder.text1.text = info.text1
        holder.text2.text = info.text2
        holder.text3.text = info.text3
        holder.text4.text = info.text4

        viewBinderHelper.bind(holder.swipeRevealLayout, position.toString())
        holder.layoutDelete.setOnClickListener {
            listInfoTwo.removeAt(holder.adapterPosition)
            notifyItemRemoved(holder.adapterPosition)
        }

    }

    override fun getItemCount(): Int {
        if (listInfoTwo == null) return 0
        return listInfoTwo.size
    }

}
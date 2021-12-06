package com.example.week03.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week03.R
import com.example.week03.model.InfoHomeOne

class AdapterNews(private val listItemNews: ArrayList<InfoHomeOne>) :
    RecyclerView.Adapter<AdapterNews.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var name: TextView = view.findViewById(R.id.tv_info_list1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_home_list1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: InfoHomeOne = listItemNews[position]

        holder.name.text = item.name
        if (position == 0) {
            holder.name.setTextColor(Color.WHITE)
            holder.name.setBackgroundResource(R.drawable.custom_radius_info2)

        } else {
            holder.name.setTextColor(Color.BLACK)
            holder.name.setBackgroundResource(R.drawable.custom_radius_info1)
        }
    }

    override fun getItemCount(): Int {
        if (listItemNews == null) return 0
        return listItemNews.size
    }
}
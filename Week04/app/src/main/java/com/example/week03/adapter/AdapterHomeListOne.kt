package com.example.week03.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

import androidx.recyclerview.widget.RecyclerView
import com.example.week03.R
import com.example.week03.model.InfoHomeOne

class AdapterHomeListOne(private val listInfoOne: ArrayList<InfoHomeOne>) :
    RecyclerView.Adapter<AdapterHomeListOne.ViewHolder>() {

    var index = -1
    var color: Int = R.drawable.custom_radius_list_home

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var name: TextView = view.findViewById(R.id.tv_info_list1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.custom_home_list1, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val info: InfoHomeOne = listInfoOne[position]

        holder.name.text = info.name

        holder.itemView.setOnClickListener {
            if (index == -1) index = position
            listInfoOne[index].check = false
            listInfoOne[position].check = true
            color = R.drawable.custom_radius_list_home
            notifyDataSetChanged()
        }

        if (info.check) {
            index = position
            holder.name.setTextColor(Color.WHITE)
            holder.name.setBackgroundResource(color)

        }
        if (!info.check) {
            holder.name.setTextColor(Color.BLACK)
            holder.name.setBackgroundResource(R.drawable.custom_radius_info1)
        }

    }

    override fun getItemCount(): Int {
        if (listInfoOne == null) return 0
        return listInfoOne.size
    }
}
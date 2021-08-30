package com.example.week03.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat

import androidx.recyclerview.widget.RecyclerView
import com.example.week03.R
import com.example.week03.model.InfoHomeOne

class AdapterHomeListOne(private val listInfoOne : ArrayList<InfoHomeOne> , private val context: Context) :
        RecyclerView.Adapter<AdapterHomeListOne.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            var name : TextView = view.findViewById(R.id.tv_info_list1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.custom_home_list1,parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val info : InfoHomeOne = listInfoOne[position]

            holder.name.text = info.name
        if(position == 0) {
            holder.name.setTextColor(Color.WHITE)
            holder.name.setBackgroundResource(R.drawable.custom_radius_info1)

        }else{
            holder.name.setTextColor(Color.BLACK)
            holder.name.setBackgroundColor(ContextCompat.getColor(context,R.color.white_two))
        }

    }

    override fun getItemCount(): Int {
        if (listInfoOne == null) return 0
        return  listInfoOne.size
    }
}
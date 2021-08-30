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
import com.example.week03.model.InfoHomeTwo

class AdapterHomeListTwo(private val listInfoTwo : ArrayList<InfoHomeTwo>, private val context: Context) :
        RecyclerView.Adapter<AdapterHomeListTwo.ViewHolder>(){

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            var text1 : TextView = view.findViewById(R.id.tv_one_list2)
            var text2 : TextView = view.findViewById(R.id.tv_two_list2)
            var text3 : TextView = view.findViewById(R.id.tv_three_list2)
            var text4 : TextView = view.findViewById(R.id.tv_four_list2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.custom_home_list2,parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val info : InfoHomeTwo = listInfoTwo[position]

        holder.text1.text = info.text1
        holder.text2.text = info.text2
        holder.text3.text = info.text3
        holder.text4.text = info.text4

    }

    override fun getItemCount(): Int {
        if (listInfoTwo == null) return 0
        return  listInfoTwo.size
    }
}
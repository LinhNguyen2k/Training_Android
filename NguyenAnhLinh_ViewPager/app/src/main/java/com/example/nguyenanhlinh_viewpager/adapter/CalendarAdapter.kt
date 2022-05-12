package com.example.nguyenanhlinh_viewpager.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.nguyenanhlinh_viewpager.OnDoubleClick
import com.example.nguyenanhlinh_viewpager.R
import com.example.nguyenanhlinh_viewpager.model.DayOfMonth
import java.util.*

class CalendarAdapter(private val daysOfMonth: ArrayList<DayOfMonth>, var context: Context?) :
    RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {
    var index = -1
    var color: Int = Color.GREEN

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tv_dayOfMonth: TextView = view.findViewById(R.id.tv_cellDayText)
        var bg_layout : ConstraintLayout = view.findViewById(R.id.constraint_layout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.custom_item, parent, false)
        val layoutParams = view.layoutParams
        layoutParams.height = (parent.height * 0.166666666).toInt()
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return daysOfMonth.size
    }

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        var days = daysOfMonth[position]

        holder.tv_dayOfMonth.text = days.day

       if (days.check){
           index = position
            holder.bg_layout.setBackgroundColor(color)
       }
        if (!days.checkDayOfMonth) {
            holder.tv_dayOfMonth.setTextColor(ContextCompat.getColor(context!!, R.color.gray))
            holder.bg_layout.isEnabled = false
        } else {
            holder.tv_dayOfMonth.setTextColor(ContextCompat.getColor(context!!, R.color.black))
        }
        holder.itemView.setOnClickListener(object : OnDoubleClick() {

            override fun onDoubleClick() {
                if (index == -1) index = position
                daysOfMonth[index].check= false
                daysOfMonth[position].check= true
                color = Color.RED
                notifyDataSetChanged()
            }

            override fun onSingleClick() {
                if (index == -1) index = position
                daysOfMonth[index].check= false
                daysOfMonth[position].check= true
                color = Color.GREEN
                notifyDataSetChanged()
            }

        })

    }
}

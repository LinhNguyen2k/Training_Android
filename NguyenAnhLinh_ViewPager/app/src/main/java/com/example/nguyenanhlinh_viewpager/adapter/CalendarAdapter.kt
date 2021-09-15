package com.example.nguyenanhlinh_viewpager.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nguyenanhlinh_viewpager.R
import java.util.ArrayList

class CalendarAdapter(private val daysOfMonth: ArrayList<String>) :
    RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {
    lateinit var onClickItem: (positions: Int) -> Unit

    fun setOnclickItem(even: (position: Int) -> Unit) {
        onClickItem = even
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tv_dayOfMonth: TextView = view.findViewById(R.id.tv_cellDayText)
        init {
            tv_dayOfMonth.setOnClickListener {
                onClickItem.invoke(adapterPosition)
            }
        }

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

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_dayOfMonth.text = daysOfMonth[position]
    }
}

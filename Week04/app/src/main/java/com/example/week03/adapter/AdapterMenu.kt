package com.example.week03.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week03.R
import com.example.week03.model.MenuItem

class AdapterMenu(private val listItemMenu: ArrayList<MenuItem>) :
    RecyclerView.Adapter<AdapterMenu.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
        const val VIEW_TYPE_THREE = 3
        const val VIEW_TYPE_FOUR = 4
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_menu_title)
        val icon: ImageView = view.findViewById(R.id.menu_item_icon)
    }

    override fun getItemCount(): Int {
        if (listItemMenu == null) return 0
        return listItemMenu.size
    }

    //override  getItemViewType
    override fun getItemViewType(position: Int): Int {
        val menuItem: MenuItem = listItemMenu[position]

        return when (menuItem.type) {
            1 -> VIEW_TYPE_ONE
            2 -> VIEW_TYPE_TWO
            3 -> VIEW_TYPE_THREE
            4 -> VIEW_TYPE_FOUR
            else -> 0
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        when (viewType) {
            VIEW_TYPE_ONE -> {
                var view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.custom_menu_viewtype1, parent, false)
                return ViewHolder(view)
            }
            VIEW_TYPE_TWO -> {
                var view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.custom_menu_viewtype2, parent, false)
                return ViewHolder(view)
            }
            VIEW_TYPE_THREE -> {
                var view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.custom_menu_viewtype3, parent, false)
                return ViewHolder(view)
            }
            VIEW_TYPE_FOUR -> {
                var view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.custom_menu_viewtype4, parent, false)
                return ViewHolder(view)
            }
            else -> {
                var view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.custom_menu_viewtype4, parent, false)
                return ViewHolder(view)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var menuItem = listItemMenu[position]
        when (holder.itemViewType) {
            VIEW_TYPE_ONE, VIEW_TYPE_TWO -> {
                holder.icon.setImageResource(menuItem.image)
                holder.title.text = menuItem.name
            }
            VIEW_TYPE_THREE -> holder.title.text = menuItem.name
            VIEW_TYPE_FOUR -> {
            }
        }
    }

}
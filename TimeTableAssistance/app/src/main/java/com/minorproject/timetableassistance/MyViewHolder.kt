package com.minorproject.timetableassistance

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder (var view: View) : RecyclerView.ViewHolder(view){

    var time = view.findViewById<TextView>(R.id.dayview_item_time)
    var sub = view.findViewById<TextView>(R.id.dayview_item_subject)
    var room = view.findViewById<TextView>(R.id.dayview_item_place)

}
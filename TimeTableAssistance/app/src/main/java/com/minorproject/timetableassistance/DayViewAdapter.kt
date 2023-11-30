package com.minorproject.timetableassistance

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DayViewAdapter(var dataList: ArrayList<TimeTableResponseDataClass>): RecyclerView.Adapter<MyViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dayview_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.time.setText(dataList[position].time)
        holder.sub.setText(dataList[position].subject)
        holder.room.setText(dataList[position].classroom)
    }

}
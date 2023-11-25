package com.minorproject.timetableassistance

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class dayViewAdapter(var dataList: ArrayList<TimeTableResponseDataClass>, var context: Context): RecyclerView.Adapter<MyViewHolder> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.dayview_item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.sub.text = dataList[position].slot1
    }

}
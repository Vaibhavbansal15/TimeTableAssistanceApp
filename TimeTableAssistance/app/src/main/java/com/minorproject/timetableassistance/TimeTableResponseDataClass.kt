package com.minorproject.timetableassistance

import com.google.gson.annotations.SerializedName

data class TimeTableResponseDataClass(

    @SerializedName("time")
    val time : String,

    @SerializedName("subject_code")
    val subject: String,

    @SerializedName("room")
    val classroom : String
)
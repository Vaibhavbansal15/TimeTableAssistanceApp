package com.minorproject.timetableassistance
import com.google.gson.annotations.SerializedName

data class TimeTableResponseDataClass(

    @SerializedName("time")
    var time : String,

    @SerializedName("subject_code")
    var subject: String,

    @SerializedName("room")
    var classroom : String
)
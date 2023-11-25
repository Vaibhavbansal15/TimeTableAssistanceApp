package com.minorproject.timetableassistance

import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("/")
    fun getData() : Call<ArrayList<TimeTableResponseDataClass>>

}
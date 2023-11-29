package com.minorproject.timetableassistance

import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    // End point of the url
    @POST("/")
    suspend fun getTimeTable(@Body requestBody : TimeTableRequest) : TimeTableResponse
}
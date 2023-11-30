package com.minorproject.timetableassistance

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private const val BASE_URL = "https://b754-2409-40d0-b2-a1cc-9144-8ee8-aa7-d6d.ngrok-free.app"
         fun getRetrofitInstance() : Retrofit{
             return Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                 .build()
         }
        val apiInterface = getRetrofitInstance().create(ApiInterface::class.java)
    }
}
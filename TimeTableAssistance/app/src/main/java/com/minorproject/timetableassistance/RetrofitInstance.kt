package com.minorproject.timetableassistance

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private const val BASE_URL = "https://app-development-9t3s.onrender.com"
         fun getRetrofitInstance() : Retrofit{
             return Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                 .build()
         }
        val apiInterface = getRetrofitInstance().create(ApiInterface::class.java)
    }
}
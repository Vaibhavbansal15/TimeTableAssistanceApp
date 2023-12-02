package com.minorproject.timetableassistance

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private const val BASE_URL = "https://c133-2409-40d0-1014-de94-91b8-b60c-5409-22ad.ngrok-free.app"
         fun getRetrofitInstance() : Retrofit{
             return Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                 .build()
         }
        val apiInterface = getRetrofitInstance().create(ApiInterface::class.java)
    }
}
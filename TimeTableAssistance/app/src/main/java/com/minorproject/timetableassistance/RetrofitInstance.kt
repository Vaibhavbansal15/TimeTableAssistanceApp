package com.minorproject.timetableassistance

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private const val BASE_URL = "https://8a33-2409-40d0-b2-a1cc-64ec-7998-546b-5c8e.ngrok-free.app"
         fun getRetrofitInstance() : Retrofit{
             return Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                 .build()
         }
        val apiInterface = getRetrofitInstance().create(ApiInterface::class.java)
    }
}
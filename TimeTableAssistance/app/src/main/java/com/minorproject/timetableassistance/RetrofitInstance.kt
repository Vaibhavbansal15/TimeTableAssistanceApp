package com.minorproject.timetableassistance

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private const val BASE_URL = "https://e202-2409-40d0-bb-52d4-d012-a995-d924-43ae.ngrok-free.app"
         fun getRetrofitInstance() : Retrofit{
             return Retrofit.Builder()
                 .baseUrl(BASE_URL)
                 .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                 .build()
         }
        val apiInterface = getRetrofitInstance().create(ApiInterface::class.java)
    }
}
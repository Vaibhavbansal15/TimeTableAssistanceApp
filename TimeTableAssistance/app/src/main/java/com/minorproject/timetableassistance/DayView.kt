package com.minorproject.timetableassistance

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
//import android.util.Log
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory

class DayView : AppCompatActivity() {

//    private var BaseUrl = "http://127.0.0.1:8000"
//    private lateinit var recyclerView : RecyclerView
//    private lateinit var myDayViewAdapter : dayViewAdapter
//    private lateinit var dataItems : ArrayList<TimeTableResponseDataClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_view)

//        recyclerView = findViewById(R.id.dayViewItems)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        getAllData()


        val dayViewTitle : TextView = findViewById(R.id.dayViewHeaderText)
        val userProfile : ImageView = findViewById(R.id.dayViewHeaderProfile)

        // Data Response from API


        dayViewTitle.setOnClickListener{
            startActivity(Intent(this, WeekView::class.java))
            finish()
        }

        userProfile.setOnClickListener{
            userMenu(it)
        }
    }

    private fun userMenu(view : View) {
        val pop = PopupMenu(this, view)
        pop.menuInflater.inflate(R.menu.user_profile_menu, pop.menu)

        pop.setOnMenuItemClickListener { item: MenuItem ->
            when(item.itemId) {
                R.id.userProfileMenuItem1 -> {
                    startActivity(Intent(this, LandingPage::class.java))
                    finish()
                    true
                }

                R.id.userProfileMenuItem2 -> {
                    startActivity(Intent(this, LoginPage::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
        pop.show()
    }

//    private fun getAllData() {
//        var retrofit = Retrofit.Builder()
//            .baseUrl(BaseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiInterface::class.java)
//
//        var retroData = retrofit.getData()
//
//        retroData.enqueue(object : Callback<ArrayList<TimeTableResponseDataClass>>{
//            fun onResponse(
//                call: Call<ArrayList<TimeTableResponseDataClass>>,
//                response: Response<List<TimeTableResponseDataClass>>
//            ) {
//                var data = response.body()!!
//                myDayViewAdapter = dayViewAdapter(data, baseContext)
//            }
//
//            fun onFailure(call: Call<List<TimeTableResponseDataClass>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//
//        })
//    }
}
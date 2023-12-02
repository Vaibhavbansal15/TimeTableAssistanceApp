package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class DayViewSaturday : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_view_saturday)

        val dayViewTitle: TextView = findViewById(R.id.tuesdayViewHeaderText)
        val userProfile: ImageView = findViewById(R.id.tuesdayViewHeaderProfile)
        val back_btn : ImageView = findViewById(R.id.dayViewBackBtn)
        val right_arrow : ImageView = findViewById(R.id.forward_arrow)
        val back_arrow : ImageView = findViewById(R.id.back_arrow)

        // Adapter View : Recycler View
        val recyclerView = findViewById<RecyclerView>(R.id.dayViewItems)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Data Source
        var timeTableList: ArrayList<TimeTableResponseDataClass> = ArrayList()
        var time: String = " "
        var sub: String = " "
        var room: String = " "

        val responseLiveData: LiveData<ArrayList<TimeTableResponseDataClass>> =
            liveData {
                var requestBody = TimeTableRequest("SAT", "B10", "Sem5_TT.json")
                var response = RetrofitInstance.apiInterface.getTimeTable(requestBody)
                Log.i("response", response.toString())
                emit(response)
            }

        responseLiveData.observe(this, Observer {
            val timeTableData = it?.listIterator()

            if (timeTableData != null) {
                while (timeTableData.hasNext()) {
                    var timeTableResponse: TimeTableResponseDataClass = timeTableData.next()
                    time = timeTableResponse.time
                    sub = timeTableResponse.subject
                    room = timeTableResponse.classroom

                    val t1 = TimeTableResponseDataClass(time, sub, room)
                    timeTableList.add(t1)
                }
                // adding the last value to the list
                val t1 = TimeTableResponseDataClass(time, sub, room)
                timeTableList.add(t1)

                // Adapter
                val myAdapter = DayViewAdapter(timeTableList)
                recyclerView.adapter = myAdapter
            }
        })

        // initializing firebase auth
        auth = FirebaseAuth.getInstance()

        // back to landing page
        back_btn.setOnClickListener{
            startActivity(Intent(this, LandingPage::class.java))
            finish()
        }

        // Switch b/w dayView and weekView
        dayViewTitle.setOnClickListener {
            startActivity(Intent(this, WeekView::class.java))
            finish()
        }

        // option menu
        userProfile.setOnClickListener {
            userMenu(it)
        }

        right_arrow.setOnClickListener{
            startActivity(Intent(this, DayView::class.java))
            finish()
        }
        back_arrow.setOnClickListener{
            startActivity(Intent(this, DayViewFriday::class.java))
            finish()
        }

    }

    private fun userMenu(view : View) {

        // inflating menu from menu resource
        val pop = PopupMenu(this, view)
        pop.menuInflater.inflate(R.menu.user_profile_menu, pop.menu)

        // making menu items clickable
        pop.setOnMenuItemClickListener { item: MenuItem ->
            when(item.itemId) {
                R.id.userProfileMenuItem1 -> {
                    startActivity(Intent(this, LandingPage::class.java))
                    finish()
                    true
                }

                R.id.userProfileMenuItem2 -> {

                    auth.signOut()
                    startActivity(Intent(this, LoginPage::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
        pop.show()
    }
}
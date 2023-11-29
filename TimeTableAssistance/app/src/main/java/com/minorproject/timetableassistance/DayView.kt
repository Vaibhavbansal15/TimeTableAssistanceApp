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
//import androidx.appcompat.app.ActionBarDrawerToggle
//import androidx.drawerlayout.widget.DrawerLayout
//import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth

class DayView : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
//    private lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_view)

//        val ttResponse = TimeTableResponse()
//        val recyclerView = findViewById<RecyclerView>(R.id.dayViewItems)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = DayViewAdapter(ttResponse, this)

        val dayViewTitle : TextView = findViewById(R.id.dayViewHeaderText)
        val userProfile : ImageView = findViewById(R.id.dayViewHeaderProfile)
//        val headerMenu : ImageView = findViewById(R.id.dayViewHeaderMenu)

//        val drawerLayout : DrawerLayout = findViewById(R.id.drawerLayout)
//        val navView : NavigationView = findViewById(R.id.nav_view)

        // Initializing retrofit service
        val retrofitService = RetrofitInstance.getRetrofitInstance()
            .create(ApiInterface::class.java)

        val responseLiveData : LiveData<TimeTableResponse> =
            liveData {
                val requestBody = TimeTableRequest("MON", "B10", "Sem5_TT.json")
                val response = RetrofitInstance.apiInterface.getTimeTable(requestBody)
                emit(response)
            }

        responseLiveData.observe(this, Observer {
            val timeTableData = it?.listIterator()

            if(timeTableData != null){
                while(timeTableData.hasNext()){
                    val timeTableResponse = timeTableData.next()
                    Log.i("time", timeTableResponse.time + "\t")
                    Log.i("course", timeTableResponse.subject + "\t")
                    Log.i("room", timeTableResponse.classroom + "\n")
                }
            }
        })

        // initializing firebase auth
        auth = FirebaseAuth.getInstance()

        // Switch b/w dayView and weekView
        dayViewTitle.setOnClickListener{
            startActivity(Intent(this, WeekView::class.java))
            finish()
        }

        // option menu
        userProfile.setOnClickListener{
            userMenu(it)
        }

//        headerMenu.setOnClickListener{
//            toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
//            drawerLayout.addDrawerListener(toggle)
//            toggle.syncState()
//
//            supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//            navView.setNavigationItemSelectedListener {
//
//                when(it.itemId){
//                    R.id.nav_weekView -> {
//                        startActivity(Intent(this, WeekView::class.java))
//                        finish()
//                    }
//
//                    R.id.nav_mon -> {
//                        startActivity(Intent(this, DayView::class.java))
//                        finish()
//                    }
//                }
//                true
//            }
//        }
//
//        fun onOptionsItemSelected(item: MenuItem): Boolean {
//            if(toggle.onOptionsItemSelected(item))
//                return true
//
//            return super.onOptionsItemSelected(item)
//        }
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
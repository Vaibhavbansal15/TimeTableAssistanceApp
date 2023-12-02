package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LandingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        val studentBtn = findViewById<Button>(R.id.StudentBtn)
        val personalBtn = findViewById<Button>(R.id.PersonalBtn)

        studentBtn.setOnClickListener{
            val intent = Intent(this,DayView::class.java)
            startActivity(intent)
            finish()
        }

        personalBtn.setOnClickListener{
//            Toast.makeText(this, "under Development", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,PersonalSchedule::class.java)
            startActivity(intent)
        }

    }
}
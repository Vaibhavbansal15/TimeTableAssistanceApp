package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WeekView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week_view)

        val weekViewTitle : TextView = findViewById(R.id.weekViewHeaderText)

        weekViewTitle.setOnClickListener{
            startActivity(Intent(this, DayView::class.java))
            finish()
        }

    }
}
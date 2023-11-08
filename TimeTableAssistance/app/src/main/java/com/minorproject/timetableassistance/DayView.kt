package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DayView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_view)

        val dayViewTitle : TextView = findViewById(R.id.dayViewHeaderText)

        dayViewTitle.setOnClickListener{
            startActivity(Intent(this, WeekView::class.java))
            finish()
        }

    }
}
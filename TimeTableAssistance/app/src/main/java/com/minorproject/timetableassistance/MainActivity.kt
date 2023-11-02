package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val studentBtn = findViewById<Button>(R.id.StudentBtn)
        val personalBtn = findViewById<Button>(R.id.PersonalBtn)

        studentBtn.setOnClickListener{
            val intent = Intent(this,LoginPage::class.java)
            startActivity(intent)
        }
    }
}
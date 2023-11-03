package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class LoadingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_page)

        val studentBtn = findViewById<Button>(R.id.StudentBtn)
        val personalBtn = findViewById<Button>(R.id.PersonalBtn)

        studentBtn.setOnClickListener{
            val intent = Intent(this,LoginPage::class.java)
            startActivity(intent)
        }

        personalBtn.setOnClickListener{
            Toast.makeText(this, "under Development", Toast.LENGTH_SHORT).show()
        }

    }
}
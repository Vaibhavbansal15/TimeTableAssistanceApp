package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class SignupPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        val signupBtn : Button = findViewById(R.id.signupBtn)
        val footerSignupBtn = findViewById<TextView>(R.id.signupBtnLoginFooter)

        footerSignupBtn.setOnClickListener{
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
        }

        signupBtn.setOnClickListener{
            Toast.makeText(this, "Signup Successful!!", Toast.LENGTH_SHORT).show()
        }
    }
}
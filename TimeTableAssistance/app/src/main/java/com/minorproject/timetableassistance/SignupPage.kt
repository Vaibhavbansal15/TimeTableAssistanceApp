package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class SignupPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        val signupBtn : Button = findViewById(R.id.signupBtn)
        val footerSignupBtn = findViewById<TextView>(R.id.signupBtnLoginFooter)
        val backBtn : ImageButton = findViewById(R.id.signup_page_back_btn)

        footerSignupBtn.setOnClickListener{
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            finish()
        }

        signupBtn.setOnClickListener{
            Toast.makeText(this, "Signup Successful!!", Toast.LENGTH_SHORT).show()
        }

        backBtn.setOnClickListener{
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }
    }
}
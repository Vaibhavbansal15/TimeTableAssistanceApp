package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class LoginPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val footerSignupBtn : TextView = findViewById(R.id.signupBtnLoginFooter)

        footerSignupBtn.setOnClickListener{
            val intent = Intent(this,SignupPage::class.java)
            startActivity(intent)
        }

        loginBtn.setOnClickListener{
            Toast.makeText(this, "Login Successful!!", Toast.LENGTH_SHORT).show()
        }
    }
}
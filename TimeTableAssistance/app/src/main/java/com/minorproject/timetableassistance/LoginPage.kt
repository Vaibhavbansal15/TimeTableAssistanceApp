package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginPage : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onStart() {
        super.onStart()

        // Checking that user Already Logged In or not
        val currUser : FirebaseUser? = auth.currentUser

        if(currUser != null){
            startActivity(Intent(this, LandingPage::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        // Initializing Firebase Auth
        auth = FirebaseAuth.getInstance()

        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val footerSignupBtn : TextView = findViewById(R.id.signupBtnLoginFooter)
        val forgotLoginPass : TextView = findViewById(R.id.loginForgotPass)

        footerSignupBtn.setOnClickListener{
            val intent = Intent(this,SignupPage::class.java)
            startActivity(intent)
            finish()
        }

        forgotLoginPass.setOnClickListener{
            startActivity(Intent(this, ResetPassword::class.java))
        }

        loginBtn.setOnClickListener{
            val email : String = findViewById<EditText>(R.id.loginEmail).text.toString()
            val pass : String = findViewById<EditText>(R.id.loginPass).text.toString()

            if(email.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "All Fields are required", Toast.LENGTH_SHORT).show()
            } else {
                auth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful){
                            Toast.makeText(this, "Login Successful!!", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, LandingPage::class.java))
                            finish()
                        } else{
                            Toast.makeText(this, "Login Failed: ${task.exception!!.message.toString()}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }
    }
}
package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignupPage : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        val signupBtn : Button = findViewById(R.id.signupBtn)
        val footerSignupBtn = findViewById<TextView>(R.id.signupBtnLoginFooter)
        val backBtn : ImageButton = findViewById(R.id.signup_page_back_btn)

        // initializing Firebase auth
        auth = FirebaseAuth.getInstance()

        footerSignupBtn.setOnClickListener{
            val intent = Intent(this, LoginPage::class.java)
            startActivity(intent)
            finish()
        }

        // Events On click Sign Up Button
        signupBtn.setOnClickListener{

            // Getting Inputs From the User
            val email : String = findViewById<EditText>(R.id.signupEmail).text.toString()
            val roll : String = findViewById<EditText>(R.id.signupEnroll).text.toString()
            val semNo : String = findViewById<EditText>(R.id.signupSemester).text.toString()
            val branch : String = findViewById<EditText>(R.id.signupBranch).text.toString()
            val batch : String = findViewById<EditText>(R.id.signupBatch).text.toString()
            val pass :String = findViewById<EditText>(R.id.signupPassword).text.toString()


            // Validating the inputs

            if(email.isEmpty() || roll.isEmpty() || semNo.isEmpty() || branch.isEmpty() || batch.isEmpty() || pass.isEmpty()){
                Toast.makeText(this,
                    "All Fields are required",
                    Toast.LENGTH_SHORT).show()
            } else if(batch.length > 3){
                Toast.makeText(this, "Invalid BATCH", Toast.LENGTH_SHORT).show()
            } else if(branch.length > 3){
                Toast.makeText(this, "Invalid BRANCH code", Toast.LENGTH_SHORT).show()
            } else if(pass.length < 6){
                Toast.makeText(this, "Password must contain at least 6 characters", Toast.LENGTH_SHORT).show()
            } else if(roll.length > 8){
                Toast.makeText(this, "Invalid EnrollmentNo.", Toast.LENGTH_SHORT).show()
            }else if(semNo.length > 1 || semNo == "9" || semNo == "0"){
                Toast.makeText(this, "Invalid Semester", Toast.LENGTH_SHORT).show()
            } else{
                auth.createUserWithEmailAndPassword(email,pass)
                    .addOnCompleteListener(this) {task ->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Signup Successful!!", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, LoginPage::class.java))
                            finish()
                        }else{
                            Toast.makeText(this, "Signup Failed : ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        backBtn.setOnClickListener{
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }
    }
}
package com.minorproject.timetableassistance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetPassword : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        auth = FirebaseAuth.getInstance()

        val resetBtn = findViewById<Button>(R.id.resetPasswordBtn)

        resetBtn.setOnClickListener{
            val resetEmail : String = findViewById<EditText>(R.id.resetPasswordEmail).text.toString()
            auth.sendPasswordResetEmail(resetEmail)
                .addOnCompleteListener(this) { task ->
                    if(task.isSuccessful){
                        Toast.makeText(this, "Check your email.", Toast.LENGTH_SHORT).show()
                    } else{
                        Toast.makeText(this, "Failed : ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
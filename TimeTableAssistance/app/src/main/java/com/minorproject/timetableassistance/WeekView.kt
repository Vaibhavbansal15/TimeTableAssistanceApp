package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class WeekView : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_week_view)

        val weekViewTitle : TextView = findViewById(R.id.weekViewHeaderText)
        val userProfile : ImageView = findViewById(R.id.weekViewHeaderProfile)

        // initializing Firebase auth
        auth = FirebaseAuth.getInstance()

        weekViewTitle.setOnClickListener{
            startActivity(Intent(this, DayView::class.java))
            finish()
        }

        userProfile.setOnClickListener{
            userMenu(it)
        }
    }

    private fun userMenu(view : View) {
        val pop = PopupMenu(this, view)
        pop.menuInflater.inflate(R.menu.user_profile_menu, pop.menu)

        pop.setOnMenuItemClickListener { item: MenuItem ->
            when(item.itemId) {
                R.id.userProfileMenuItem1 -> {
                    startActivity(Intent(this, LandingPage::class.java))
                    finish()
                    true
                }

                R.id.userProfileMenuItem2 -> {
                    auth.signOut()
                    Toast.makeText(this, "Logged Out!!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginPage::class.java))
                    finish()
                    true
                }
                else -> false
            }
        }
        pop.show()
    }
}
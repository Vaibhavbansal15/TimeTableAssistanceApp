package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class DayView : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_view)

        val dayViewTitle : TextView = findViewById(R.id.dayViewHeaderText)
        val userProfile : ImageView = findViewById(R.id.dayViewHeaderProfile)

        // initializing firebase auth
        auth = FirebaseAuth.getInstance()

        // Switch b/w dayView and weekView
        dayViewTitle.setOnClickListener{
            startActivity(Intent(this, WeekView::class.java))
            finish()
        }

        // option menu
        userProfile.setOnClickListener{
            userMenu(it)
        }
    }

    private fun userMenu(view : View) {

        // inflating menu from menu resource
        val pop = PopupMenu(this, view)
        pop.menuInflater.inflate(R.menu.user_profile_menu, pop.menu)

        // making menu items clickable
        pop.setOnMenuItemClickListener { item: MenuItem ->
            when(item.itemId) {
                R.id.userProfileMenuItem1 -> {
                    startActivity(Intent(this, LandingPage::class.java))
                    finish()
                    true
                }

                R.id.userProfileMenuItem2 -> {
                    auth.signOut()
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
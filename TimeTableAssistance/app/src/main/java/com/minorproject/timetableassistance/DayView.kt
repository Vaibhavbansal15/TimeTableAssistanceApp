package com.minorproject.timetableassistance

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class DayView : AppCompatActivity() {

    private val customMenu = com.minorproject.timetableassistance.CustomMenu()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_view)

        val dayViewTitle : TextView = findViewById(R.id.dayViewHeaderText)
        val userProfile : ImageView = findViewById(R.id.dayViewHeaderProfile)

        dayViewTitle.setOnClickListener{
            startActivity(Intent(this, WeekView::class.java))
            finish()
        }

        userProfile.setOnClickListener{

            customMenu.customMenu(this, it)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.userProfileMenuItem1 -> {
                startActivity(Intent(this, LandingPage::class.java))
                finish()
                true
            }
            R.id.userProfileMenuItem2 -> {
                startActivity(Intent(this, LoginPage::class.java))
                true
            }
            else -> false
        }
        return false
    }
}
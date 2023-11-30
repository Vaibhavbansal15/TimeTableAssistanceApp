package com.minorproject.timetableassistance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.TextView


class PersonalSchedule : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_schedule)

        val gridLayout: GridLayout = findViewById(R.id.gridLayout)

        for (row in 0 until gridLayout.rowCount) {
            for (col in 0 until gridLayout.columnCount) {
                val box = TextView(this)
                box.text = "Click me!"
                box.layoutParams = GridLayout.LayoutParams().apply {
                    rowSpec = GridLayout.spec(row)
                    columnSpec = GridLayout.spec(col)
                    width = 0
                    height = GridLayout.LayoutParams.WRAP_CONTENT
                    setMargins(8, 8, 8, 8)
                }

                box.setOnClickListener {
                    handleGridItemClick(row, col)
                }

                gridLayout.addView(box)
            }
        }
    }

    private fun handleGridItemClick(row: Int, col: Int) {
        // Show click effect (you can use animations or change background color)
        val clickedView: View? = (findViewById<GridLayout>(R.id.gridLayout)).getChildAt(row * 6 + col)
        clickedView?.setBackgroundResource(android.R.color.holo_blue_light)

        // TODO: Implement your logic for handling user input in this box
    }
}
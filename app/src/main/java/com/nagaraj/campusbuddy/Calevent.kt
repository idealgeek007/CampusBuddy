package com.nagaraj.campusbuddy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CalendarView
import android.widget.ImageButton
import android.widget.ListView

class Calevent : AppCompatActivity() {

    lateinit var calendarView: CalendarView
    lateinit var eventListView: ListView
    val events = arrayOf(
        "Event 1", "Event 2", "Event 3",
        "Event 4", "Event 5", "Event 6",
        "Event 7", "Event 8", "Event 9"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calevent)



        calendarView = findViewById(R.id.calendarView)
        eventListView = findViewById(R.id.eventview)

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->

        }

        val eventAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, events)
        eventListView.adapter = eventAdapter


        val homeButton = findViewById<ImageButton>(R.id.homepage)
        homeButton.setOnClickListener {
            // Navigate to the UserPageActivity when the "User" button is clicked
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }
        val userButton = findViewById<ImageButton>(R.id.user)
        userButton.setOnClickListener {
            // Navigate to the UserPageActivity when the "User" button is clicked
            val intent = Intent(this, Userpage::class.java)
            startActivity(intent)

        }
    }
}
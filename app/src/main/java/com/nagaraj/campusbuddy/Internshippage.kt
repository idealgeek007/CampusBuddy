package com.nagaraj.campusbuddy

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView



class Internshippage : AppCompatActivity() {
    lateinit var eventListView: ListView
    val events = arrayOf(
        "Opportunity 1","Opportunity 2","Opportunity 3","Opportunity 4","Opportunity 5",
        "Opportunity 6","Opportunity 7","Opportunity 8","Opportunity 9","Opportunity 10",
        "Opportunity 11","Opportunity 12","Opportunity 13","Opportunity 14","Opportunity 15",
        "Opportunity 16","Opportunity 17","Opportunity 18","Opportunity 19","Opportunity 20",
        "Opportunity 21","Opportunity 22","Opportunity 23","Opportunity 24","Opportunity 25",
        "Opportunity 26","Opportunity 27","Opportunity 28","Opportunity 29","Opportunity 30",

    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_internshippage)


        eventListView = findViewById(R.id.opplist)
        val eventAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, events)
        eventListView.adapter = eventAdapter




        val userButton = findViewById<ImageButton>(R.id.user)
        userButton.setOnClickListener {
            // Navigate to the UserPageActivity when the "User" button is clicked
            val intent = Intent(this, Userpage::class.java)
            startActivity(intent)

        }
        val homeButton = findViewById<ImageButton>(R.id.homepage)
        homeButton.setOnClickListener {
            // Navigate to the UserPageActivity when the "User" button is clicked
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }

    }
}
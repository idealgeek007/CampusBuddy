package com.nagaraj.campusbuddy

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton

class Userpage : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userpage)




        val homeButton = findViewById<ImageButton>(R.id.homepage)
        homeButton.setOnClickListener {
            // Navigate to the UserPageActivity when the "User" button is clicked
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
    }




}}
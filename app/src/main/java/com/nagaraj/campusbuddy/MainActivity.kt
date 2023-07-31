package com.nagaraj.campusbuddy

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val userButton = findViewById<ImageButton>(R.id.user)
        userButton.setOnClickListener {
            // Navigate to the UserPageActivity when the "User" button is clicked
            val intent = Intent(this, Userpage::class.java)
            startActivity(intent)

        }

        val memebutton = findViewById<ImageView>(R.id.memephoto)
        memebutton.setOnClickListener {
            // Navigate to the UserPageActivity when the "User" button is clicked
            val intent = Intent(this, Memepage::class.java)
            startActivity(intent)

        }
        val eventclick = findViewById<ImageView>(R.id.eventphoto)
        eventclick.setOnClickListener{
            val intent = Intent(this, Calevent::class.java)
            startActivity(intent)
        }
        val internclick = findViewById<ImageView>(R.id.internphoto)
        internclick.setOnClickListener{
            val intent = Intent(this, Internshippage::class.java)
            startActivity(intent)
        }

        val openGoogleForm = findViewById<ImageView>(R.id.maintphoto)
        val googleFormUrl = "https://forms.gle/jAKTCTLVbkLmWeYr5"

        openGoogleForm.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)

            intent.data = Uri.parse(googleFormUrl)
                startActivity(intent)
            }
        val resourcesclick = findViewById<ImageView>(R.id.resphoto)
        val reslink = "https://sdmcselibrary.blogspot.com/p/login.html"

        resourcesclick.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(reslink)
            startActivity(intent)
        }
    }

}

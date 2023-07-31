package com.nagaraj.campusbuddy

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class Memepage : AppCompatActivity() {
    var currentImageUrl : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memepage)
        loadmeme()
    }

    private fun loadmeme() {
        val queue = Volley.newRequestQueue(this as Context)
        val url = "https://meme-api.com/gimme"
        var memeImageView = findViewById<ImageView>(R.id.memeImageView)
// Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                currentImageUrl = response.getString("url")


                Glide.with(this).load(currentImageUrl).listener(object : RequestListener<Drawable> {

                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
                        progressBar.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

                        progressBar.visibility = View.GONE
                        return false
                    }
                }).into(memeImageView)

            },
            {
                Toast.makeText(this, "Something Went wrong", Toast.LENGTH_SHORT).show()
            }
        )

        queue.add(jsonObjectRequest)

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


    fun shareMeme(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_TEXT,"Hey Check out this meme Noob $currentImageUrl")
        val chooser = Intent.createChooser(intent, "Share this meme using ...")
        startActivity(chooser)
    }

    fun nextMeme(view: View) {
        loadmeme()
    }
}
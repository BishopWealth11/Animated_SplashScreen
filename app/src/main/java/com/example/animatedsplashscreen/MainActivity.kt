
package com.example.animatedsplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val SPLASH_SCREEN = 5000

    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation

    private lateinit var imageView : ImageView
    private lateinit var title_txt : TextView
    private lateinit var description_txt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar!!.hide()

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        imageView = findViewById(R.id.hr_dshr)
        title_txt = findViewById(R.id.title_text)
        description_txt = findViewById(R.id.text_vieww)

        imageView.animation = topAnimation
        title_txt.animation = bottomAnimation
        description_txt.animation = bottomAnimation

        Handler((Looper.getMainLooper())).postDelayed({

        val intent = Intent(this, AnotherActivity :: class.java)
            startActivity(intent)
            finish()


        }, 7000)

    }
}
package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.VideoView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val video = findViewById<VideoView>(R.id.splash_screen)
        val videoPath = "android.resource://$packageName/raw/splash_screen"
        video.setVideoPath(videoPath)
        video.setOnCompletionListener {
            val r = object:Runnable{
                override fun run() {
                    startActivity(Intent(applicationContext,MainActivity::class.java))
                    finish()
                }

            }
            Handler().postDelayed(r,500)
        }
        video.start()
    }
}
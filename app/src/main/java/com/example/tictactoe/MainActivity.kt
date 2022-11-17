package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnSettings=findViewById<Button>(R.id.settings_btn)
        var btnPlay=findViewById<Button>(R.id.play_btn)
        var btnQuit=findViewById<Button>(R.id.quit_btn)

        btnPlay.setOnClickListener {
            var intent = Intent(applicationContext,GameActivity::class.java)
            startActivity(intent)
        }
        btnSettings.setOnClickListener {
            var intent = Intent(applicationContext,SettingsActivity::class.java)
            startActivity(intent)
        }
        btnQuit.setOnClickListener {
            finish()
        }
    }
}

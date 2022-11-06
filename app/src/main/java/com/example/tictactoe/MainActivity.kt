package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn_play=findViewById<Button>(R.id.play_btn)
        btn_play.setOnClickListener {
            var intent = Intent(applicationContext,GameActivity::class.java)
            startActivity(intent)
        }
    }
}

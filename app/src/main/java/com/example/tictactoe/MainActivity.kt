package com.example.tictactoe


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility=
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
            View.SYSTEM_UI_FLAG_FULLSCREEN or
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
            View.SYSTEM_UI_FLAG_FULLSCREEN or
            View.SYSTEM_UI_FLAG_IMMERSIVE


        var btnSettings=findViewById<ImageButton>(R.id.settings_btn)
        var btnPlay=findViewById<ImageButton>(R.id.play_btn)
        var btnQuit=findViewById<ImageButton>(R.id.quit_btn)
        var btnHistory = findViewById<ImageButton>(R.id.history_btn)


        btnPlay.setOnClickListener {
            var intent = Intent(applicationContext,GameActivity::class.java)
            startActivity(intent)
        }
        btnSettings.setOnClickListener {
            startActivity(Intent(applicationContext,SettingsActivity::class.java))
        }
        btnQuit.setOnClickListener {
            finish()
        }
        btnHistory.setOnClickListener{
            var intent =Intent(applicationContext,HistoryActivity::class.java)
            startActivity(intent)
        }
    }
}


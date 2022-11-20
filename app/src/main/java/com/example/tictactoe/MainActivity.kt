package com.example.tictactoe


import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnSettings=findViewById<Button>(R.id.settings_btn)
        var btnPlay=findViewById<Button>(R.id.play_btn)
        var btnQuit=findViewById<Button>(R.id.quit_btn)
        var btnHistory = findViewById<Button>(R.id.history_btn)


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

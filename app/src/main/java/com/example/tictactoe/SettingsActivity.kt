package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Switch

class SettingsActivity : AppCompatActivity() {
    private lateinit var switch:Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        switch  = findViewById<Switch>(R.id.switch_button)

        if(SingletonClass.getSoundStatus()){
            switch.isChecked=true
        }

        switch.setOnClickListener {
           SingletonClass.toggleSound()
        }
    }
}
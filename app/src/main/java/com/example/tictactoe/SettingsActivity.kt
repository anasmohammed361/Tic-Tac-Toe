package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch

class SettingsActivity : AppCompatActivity() {
    private var sound:Boolean = SingletonClass.getSoundStatus()
    private lateinit var switch:Switch
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        switch  = findViewById<Switch>(R.id.switch_button)
    var applyBtn=findViewById<Button>(R.id.apply_btn)
    applyBtn.setOnClickListener {
        var i = Intent(applicationContext,MainActivity::class.java)
        startActivity(i)
    }
        if(sound){
            switch.isChecked=true
        }

        switch.setOnClickListener {
            SingletonClass.toggleSound()
        }
    }
}
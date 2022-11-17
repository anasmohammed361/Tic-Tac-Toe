package com.example.tictactoe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch

class SettingsActivity : AppCompatActivity() {
    var sound:Boolean = false
    lateinit var switch:Switch
//    @SuppressLint("UseSwitchCompatOrMaterialCode", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        var bundle = intent.extras
        sound= bundle?.getBoolean("sound") == true

        switch  = findViewById<Switch>(R.id.switch_button)
    var applyBtn=findViewById<Button>(R.id.apply_btn)
    applyBtn.setOnClickListener {
        var b=Bundle()
        var i = Intent(applicationContext,MainActivity::class.java)
        b.putBoolean("sound",sound)
        i.putExtras(b)
        startActivity(i)
    }
        if(sound){
            switch.isChecked=true
        }

        switch.setOnClickListener {
            sound = switch.isChecked
        }
    }
}
package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager.getDefaultSharedPreferences
import android.widget.Button

import android.widget.Switch
import androidx.core.content.edit
import com.google.android.material.textfield.TextInputEditText

class SettingsActivity : AppCompatActivity() {
    private lateinit var switch:Switch
    private var sound = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val p1 = findViewById<TextInputEditText>(R.id.player_1_input)
        val p2 = findViewById<TextInputEditText>(R.id.player_2_input)
        val applyBtn = findViewById<Button>(R.id.apply_btn)
        switch  = findViewById<Switch>(R.id.switch_button)

        val pref = getDefaultSharedPreferences(applicationContext)
        val editor = pref.edit()
        sound = pref.getBoolean("sound",true)
        if(sound){
            switch.isChecked=true
        }

        switch.setOnClickListener {
            sound = !sound
        }
        applyBtn.setOnClickListener {
            if(validate(p1,p2)) {
                editor.putString("player1", p1.text.toString())
                editor.putString("player2", p2.text.toString())
            }
                    editor.putBoolean("sound",sound)
                    editor.apply()
                finish()

        }
    }



    private fun validate(p1:TextInputEditText,p2:TextInputEditText):Boolean{
        if (p1.text?.isEmpty()!!){
            p1.error = "Name cant be empty"
            return false
        }
        if (p2.text?.isEmpty()!!){
            p2.error = "Name cant be empty"
            return false
        }
        return true
    }
}
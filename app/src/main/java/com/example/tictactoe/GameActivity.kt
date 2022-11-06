package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GameActivity : AppCompatActivity() {
    var winConditions=arrayOf("123","456","789","147","258","369","159","357")
    var xPressed=arrayOf<String>()
    var oPressed=arrayOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2)
    }
    fun pressBtn(){

    }
}
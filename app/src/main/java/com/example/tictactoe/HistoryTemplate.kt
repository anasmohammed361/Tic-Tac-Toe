package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.tictactoe.database.AppDataBase

class HistoryTemplate : AppCompatActivity() {
    var winConditions=arrayOf("1 2 3","4 5 6","7 8 9","1 4 7","2 5 8","3 6 9","1 5 9","3 5 7")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_template)
        val statArr = intent.getStringExtra("matchStats")?.split("|")
        val win = intent.getStringExtra("winStat")

        val textArray = arrayOf<TextView>(
            findViewById(R.id.txt_1),
            findViewById(R.id.txt_2),
            findViewById(R.id.txt_3),
            findViewById(R.id.txt_4),
            findViewById(R.id.txt_5),
            findViewById(R.id.txt_6),
            findViewById(R.id.txt_7),
            findViewById(R.id.txt_8),
            findViewById(R.id.txt_9)
            )

        val winningLines = arrayOf<View>(
            findViewById(R.id.row_1),
            findViewById(R.id.row_2),
            findViewById(R.id.row_3),
            findViewById(R.id.column_1),
            findViewById(R.id.column_2),
            findViewById(R.id.column_3),
            findViewById(R.id.diagonal_left),
            findViewById(R.id.diagonal_right),
        )
        for(i in statArr?.get(0)?.split("-")!!){
            textArray[i.toInt()-1].text = "X"
        }
        for(i in statArr?.get(1)?.split("-")!!){
            textArray[i.toInt()-1].text = "O"
        }
        winningLines[winConditions.indexOf(win)].visibility=View.VISIBLE
    }
}
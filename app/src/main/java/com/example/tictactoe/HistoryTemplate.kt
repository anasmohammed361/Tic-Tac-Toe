package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.tictactoe.database.AppDataBase

class HistoryTemplate : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_template)
        val textArray = arrayOf(
            findViewById<TextView>(R.id.txt_1),
            findViewById<TextView>(R.id.txt_2),
            findViewById<TextView>(R.id.txt_3),
            findViewById<TextView>(R.id.txt_4),
            findViewById<TextView>(R.id.txt_5),
            findViewById<TextView>(R.id.txt_6),
            findViewById<TextView>(R.id.txt_7),
            findViewById<TextView>(R.id.txt_8),
            findViewById<TextView>(R.id.txt_9)
            )

        val winningLines = arrayOf(
            findViewById<View>(R.id.row_1),
            findViewById<View>(R.id.row_2),
            findViewById<View>(R.id.row_3),
            findViewById<View>(R.id.column_1),
            findViewById<View>(R.id.column_2),
            findViewById<View>(R.id.column_3),
            findViewById<View>(R.id.diagonal_left),
            findViewById<View>(R.id.diagonal_right),
        )
    }
}
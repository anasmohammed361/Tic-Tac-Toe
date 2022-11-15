package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*


class GameActivity : AppCompatActivity() {
    var winConditions=arrayOf("1 2 3","4 5 6","7 8 9","1 4 7","2 5 8","3 6 9","1 5 9","3 5 7")
    var states= arrayOf("X","O")
    var index=0
    private var xPressed=arrayOf<String>()
    private var oPressed=arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2)
    }

    fun pressBtn(view: View) {
        var btn = view as Button
        var temp:String
        if(index%2 == 0 && (btn.text.toString() !in states)) {
            index++
            temp=btn.text.toString()
            btn.textSize= 20F
            btn.text=states[0]
            xPressed=xPressed.plus(temp)
            if(checkWon(xPressed)){

            }
        }else if((btn.text.toString() !in states)){
            index++
            temp=btn.text.toString()
            btn.textSize= 20F
            btn.text=states[1]
            oPressed=oPressed.plus(temp)
            if(checkWon(oPressed)){

            }
        }

    }

    private fun checkWon(arr:Array<String>):Boolean{
        for (i in winConditions){
            if(i.split(" ").all{arr.contains(it)}){
                return true
            }
        }
        return false
    }
}
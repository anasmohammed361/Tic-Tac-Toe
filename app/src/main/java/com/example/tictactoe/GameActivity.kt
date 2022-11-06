package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text


class GameActivity : AppCompatActivity() {
    var winConditions=arrayOf("123","456","789","147","258","369","159","357")
    var index=0
    var xPressed=arrayOf<String>()
    var oPressed=arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2)
    }

    fun pressBtn(view: View) {
        var text=findViewById<TextView>(R.id.text)
        var btn = view as Button
        var temp:String
        if(index%2 == 0) {
            temp=btn.text.toString()
            btn.textSize= 20F
            btn.text="X"
            xPressed.plus(temp)
//            Log.d("Value",xPressed[0])
            if(checkWon(xPressed)){
                text.text="X Won"
            }
        }else{
            temp=btn.text.toString()
            btn.textSize= 20F
            btn.text="O"
            oPressed.plus(temp)
            if(checkWon(oPressed)){
                text.text="O Won"
            }
        }
        index++
    }

    private fun checkWon(arr:Array<String>):Boolean{
         var anoFun: (String) -> Boolean = {arr.contains(it)}
        for (i in winConditions){
            if(i.split("").all(anoFun)){
                return true
            }
        }
        return false
    }

}
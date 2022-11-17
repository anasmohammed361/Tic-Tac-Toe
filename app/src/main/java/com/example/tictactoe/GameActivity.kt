package com.example.tictactoe

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import java.util.*


class GameActivity : AppCompatActivity() {
//    private lateinit var appDb : AppDataBase
    var sound:Boolean=true
    private lateinit var media:MediaPlayer
    private var matchNum=0;
    var winConditions=arrayOf("1 2 3","4 5 6","7 8 9","1 4 7","2 5 8","3 6 9","1 5 9","3 5 7")
    var states= arrayOf("X","O")
    var index=0
    private var xPressed=arrayOf<String>()
    private var oPressed=arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
//        appDb=AppDataBase.getDataBase(this)
        sound= intent.extras?.getBoolean("sound") == true
        super.onCreate(savedInstanceState )
        setContentView(R.layout.activity_game2)
    }

    fun pressBtn(view: View) {
        var stats:String
        var btn = view as Button
        var temp:String
        sound()
        if(index%2 == 0 && (btn.text.toString() !in states)) {
            index++
            temp=btn.text.toString()
            btn.textSize= 20F
            btn.text=states[0]
            xPressed=xPressed.plus(temp)
            stats=checkWon(xPressed);
            if(stats.isNotEmpty()){
//                writeDataToDb("X",xPressed.joinToString("-")+"|"+oPressed.joinToString("-"),stats)
                showDialog("X has won. ")
            }
        }else if((btn.text.toString() !in states)){
            index++
            temp=btn.text.toString()
            btn.textSize= 20F
            btn.text=states[1]
            oPressed=oPressed.plus(temp)
            stats = checkWon(oPressed)
            if(stats.isNotEmpty()){
                showDialog("O has won. ")
//                    writeDataToDb("O",xPressed.joinToString("-")+"|"+oPressed.joinToString("-"),stats)
                }

        }
        if(xPressed.size + oPressed.size >=9){
            showDialog("Oops! It is a Tie...")
        }
    }

    private fun checkWon(arr:Array<String>):String{
        for (i in winConditions){
            if(i.split(" ").all{arr.contains(it)}){
                return i
            }
        }
        return ""
    }

//    private fun writeDataToDb(winner:String,match_stats:String,winning_row:String){
//        val db= DataBase(
//            null,matchNum,winner,match_stats,winning_row
//        )
//        matchNum++
//        GlobalScope.launch(Dispatchers.IO){
//            appDb.dbInstance().insert(db)
//        }
//    }
//    private fun readDb(match_id:Int):DataBase{
//        lateinit var db : DataBase
//
//        GlobalScope.launch {
//            db = appDb.dbInstance().findByMatchNumber(match_id)
//        }
//        return db
//    }
//
    private fun sound(){
    if (!sound){
        return
    }
        if(!this::media.isInitialized){
            media = MediaPlayer.create(applicationContext,R.raw.bubble_pop)
        }
        if(media.isPlaying){
            media.pause()
            media.seekTo(0)
        }
        media.start()
    }

    override fun onDestroy() {
        if(this::media.isInitialized){
            media.stop()
            media.release()
        }
        super.onDestroy()
    }


    private fun showDialog(text:String){
        val builder = AlertDialog.Builder(this)
        builder.setMessage("$text Restart the game?")
        builder.setCancelable(false)
        builder.setPositiveButton("Yes"){
            dialog,which -> restartActivity(this)
        }
        builder.setNegativeButton("No"){
            dialog,which ->
            run {
                var i = Intent(applicationContext, MainActivity::class.java)
                var b=Bundle()
                b.putBoolean("sound",sound)
                i.putExtras(b)
                startActivity(i)
            }
        }
        val alertDialog = builder.create()
        alertDialog.show()
    }

    private fun restartActivity(activity:Activity){
        if(Build.VERSION.SDK_INT>=11){
            activity.recreate()
        }else{
            activity.finish()
            activity.startActivity(activity.intent)
        }
    }


}
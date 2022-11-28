package com.example.tictactoe

import android.app.Activity
import android.app.AlertDialog
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager.getDefaultSharedPreferences
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.tictactoe.database.AppDataBase
import com.example.tictactoe.database.DataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class GameActivity : AppCompatActivity() {
    private var completed:Boolean = false
    private lateinit var appDb : AppDataBase
    private lateinit var media:MediaPlayer

    var winConditions=arrayOf("1 2 3","4 5 6","7 8 9","1 4 7","2 5 8","3 6 9","1 5 9","3 5 7")
    var states= arrayOf("X","O")
    var index=0
    private var xPressed=arrayOf<String>()
    private var oPressed=arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        appDb=AppDataBase.getDataBase(this)
        super.onCreate(savedInstanceState )
        setContentView(R.layout.activity_game2)
    }

    fun pressBtn(view: View) {
        if(completed){
            return
        }
        var stats:String
        var btn = view as Button
        var temp:String
        btnClickSound()
        if(index%2 == 0 && (btn.text.toString() !in states)) {
            index++
            temp=btn.text.toString()
            btn.textSize= 20F
            btn.text=states[0]
            xPressed=xPressed.plus(temp)
            stats=checkWon(xPressed);
            if(stats.isNotEmpty()){
                completed=true
                val player=getDefaultSharedPreferences(applicationContext).getString("player1","Player-1")+"|"+
                        getDefaultSharedPreferences(applicationContext).getString("player2","Player-2")
                Log.d("Won",player)
                writeDataToDb("X",xPressed.joinToString("-")+"|"+oPressed.joinToString("-"),stats,player)
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
                completed=true
                val player= getDefaultSharedPreferences(applicationContext).getString("player1","Player-1")+"|"+
                        getDefaultSharedPreferences(applicationContext).getString("player2","Player-2")
                Log.d("Won",player)
                writeDataToDb("O",xPressed.joinToString("-")+"|"+oPressed.joinToString("-"),stats,player)
                showDialog("O has won. ")
                }

        }
        if(xPressed.size + oPressed.size >=9){
            completed=true
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

    private fun writeDataToDb(winner:String,match_stats:String,winning_row:String,players:String){
        val dbData= DataBase(
            null,winner,match_stats,winning_row,players
        )
        GlobalScope.launch(Dispatchers.IO){
            appDb.dbInstance().insert(dbData)
        }
    }


    private fun btnClickSound(){
    if (!getDefaultSharedPreferences(applicationContext).getBoolean("sound",true)){
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
//            dialog,which -> startActivity(Intent(applicationContext, MainActivity::class.java))
            dialog,which -> finish()
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
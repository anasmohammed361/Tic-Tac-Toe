package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tictactoe.database.AppDataBase
import com.example.tictactoe.database.DataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    private lateinit var appDb : AppDataBase
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var data: List<DataBase>
    private lateinit var  newArrayList: ArrayList<Stats>
    private lateinit var imageId:Array<Int>
    private lateinit var text0Arr:Array<String>
    private lateinit var text1Arr:Array<String>
    private lateinit var text2Arr:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        appDb= AppDataBase.getDataBase(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        newRecyclerView = findViewById(R.id.recycler_view)
        }

    override fun onResume() {
        super.onResume()
        GlobalScope.launch {
            data = appDb.dbInstance().getAll()
            Log.d("Size", data.size.toString())
            Log.d("Firstval",data[0].winner)
            imageId= arrayOf()
            text0Arr = arrayOf()
            text1Arr = arrayOf()
            text2Arr = arrayOf()
            newArrayList= arrayListOf()
            var participantsArray: List<String>
            val len = data.size
            for (i in data) {
                participantsArray = i.participants.split("|")
                imageId.plus(if (i.winner == "X") R.drawable.x_img else R.drawable.o_img)
                text0Arr.plus(i.participants.replace("|", "vs"))
                text1Arr.plus(participantsArray[0] + "- X ||" + participantsArray[1] + "- O")
                text2Arr.plus("Winner - " + if (i.winner == "X") participantsArray[0] else participantsArray[1])
            }
            for(i in text0Arr.indices){
                val stat = Stats(imageId[i],text0Arr[i],text1Arr[i],text2Arr[i])
                newArrayList.add(stat)
            }
            newRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@HistoryActivity)
                adapter = MyAdapter().apply{
                    setData(newArrayList.toList())
                }
            }
    }

    }






}
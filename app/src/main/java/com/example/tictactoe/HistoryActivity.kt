package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tictactoe.database.AppDataBase
import com.example.tictactoe.database.DataBase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    private lateinit var appDb : AppDataBase
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var data:List<DataBase>
    private lateinit var  newArrayList: ArrayList<Stats>
    private lateinit var imageId:Array<Int>
    private lateinit var text0Arr:Array<String>
    private lateinit var text1Arr:Array<String>
    private lateinit var text2Arr:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        appDb= AppDataBase.getDataBase(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        fetchDataFromDb()
        var participantsArray:List<String>
        val len = data.size
        for(i in data){
            participantsArray = i.participants.split("|")
            imageId.plus(if (i.winner=="X") R.drawable.x_img else R.drawable.o_img)
            text0Arr.plus(i.participants.replace("|","vs"))
            text1Arr.plus(participantsArray[0] + "- X ||"+participantsArray[1] + "- O")
            text2Arr.plus("Winner - " + if(i.winner=="X") participantsArray[0] else participantsArray[1])
        }

//        imageId= arrayOf(
//            R.drawable.x_img,
//            R.drawable.o_img
//        )
//        text0Arr= arrayOf(
//            "Likith vs Anas",
//            "Rithik vs Betsy"
//        )
//        text1Arr = arrayOf(
//            "Likith - X | Anas - O",
//            "Betsy - X | Rithik - O"
//        )
//        text2Arr= arrayOf(
//            "Winner : Anas",
//            "Winner : Betsy"
//        )


        newRecyclerView  = findViewById(R.id.recycler_view)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf()
        getUserData()
    }

    private fun getUserData() {
        for(i in imageId.indices){
            val stat = Stats(imageId[i],text0Arr[i],text1Arr[i],text2Arr[i])
            newArrayList.add(stat)
        }
        newRecyclerView.adapter = MyAdapter(newArrayList)
    }

    private fun fetchDataFromDb(){
        GlobalScope.launch {
            data =  appDb.dbInstance().getAll()
        }
    }

}
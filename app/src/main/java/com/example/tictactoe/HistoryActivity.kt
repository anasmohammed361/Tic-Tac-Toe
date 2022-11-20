package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {
    private lateinit var newRecyclerView: RecyclerView
    private lateinit var  newArrayList: ArrayList<Stats>
    lateinit var imageId:Array<Int>
    lateinit var text0Arr:Array<String>
    lateinit var text1Arr:Array<String>
    lateinit var text2Arr:Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        imageId= arrayOf(
            R.drawable.x_img,
            R.drawable.o_img
        )
        text0Arr= arrayOf(
            "Likith vs Anas",
            "Rithik vs Betsy"
        )
        text1Arr = arrayOf(
            "Likith - X | Anas - O",
            "Betsy - X | Rithik - O"
        )
        text2Arr= arrayOf(
            "Winner : Anas",
            "Winner : Betsy"
        )

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
}
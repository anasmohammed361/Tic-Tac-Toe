package com.example.tictactoe.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "logs")
data class DataBase(
    @PrimaryKey(autoGenerate = true)  val id:Int?,
    val winner:String,
    val match_stats:String,
    val win_stat:String
)

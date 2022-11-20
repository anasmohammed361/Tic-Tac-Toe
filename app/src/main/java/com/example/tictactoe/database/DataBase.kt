package com.example.tictactoe.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "logs")
data class DataBase(
    @PrimaryKey(autoGenerate = true)  val id:Int?,
    @ColumnInfo(name = "winner")
    val winner:String,
    @ColumnInfo(name = "match_stats")
    val match_stats:String,
    @ColumnInfo(name = "winning_row")
    val win_stat:String
)

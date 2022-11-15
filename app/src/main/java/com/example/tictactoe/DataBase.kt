package com.example.tictactoe

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Logs")
data class DataBase(
    @PrimaryKey(autoGenerate = true)  val id:Int?,
    @ColumnInfo(name = "match_no") val match_no:Int?,
    @ColumnInfo(name = "winner") val winner:String?,
    @ColumnInfo(name = "loser") val loser:String?,
    @ColumnInfo(name = "match_stats") val match_stats:String?,
    @ColumnInfo(name = "winning_row") val win_stat:String?
)

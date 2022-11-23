package com.example.tictactoe

import com.example.tictactoe.database.DataBase

data class Stats(
    var winningImage:Int,
    var players:String,
    var player_x:String,
    var player_y:String,
    var dbData:DataBase
)

package com.example.tictactoe.database

import androidx.room.*

@Dao
interface DBInterface {
    @Query("SELECT * FROM logs")
    fun getAll(): List<DataBase>

    @Query("SELECT * FROM Logs WHERE :match LIKE :match LIMIT 1")
    suspend fun findByMatchNumber(match:Int?): DataBase

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(db:DataBase)

}
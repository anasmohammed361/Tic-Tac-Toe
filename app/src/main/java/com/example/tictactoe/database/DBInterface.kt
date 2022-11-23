package com.example.tictactoe.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DBInterface {
    @Query("SELECT * FROM logs")
    fun getAll(): List<DataBase>

    @Query("SELECT * FROM Logs WHERE :match LIKE :match LIMIT 1")
    suspend fun findByMatchNumber(match:Int?): DataBase

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(db:DataBase)

//    @Delete
//    suspend fun delete(db: DataBase)
//
//    @Query("DELETE FROM Logs")
//    suspend fun deleteAll()

}
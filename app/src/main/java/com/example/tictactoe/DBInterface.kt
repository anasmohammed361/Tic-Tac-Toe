package com.example.tictactoe

import androidx.room.*

@Dao
interface DBInterface {
    @Query("SELECT * FROM Logs")
    fun getAll():List<DataBase>

    @Query("SELECT * FROM Logs WHERE match_no LIKE :match LIMIT 1")
    suspend fun findByMatchNumber(match:Int):DataBase

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(db:DataBase)

    @Delete
    suspend fun delete(db:DataBase)

    @Query("DELETE FROM Logs")
    suspend fun deleteAll()

}
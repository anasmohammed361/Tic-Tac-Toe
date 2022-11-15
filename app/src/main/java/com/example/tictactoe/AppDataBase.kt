package com.example.tictactoe

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataBase :: class], version = 1)
abstract class AppDataBase:RoomDatabase() {

    abstract fun dbInstance() : DBInterface

    companion object{

        @Volatile
        private var INSTANCE : AppDataBase? =null

        fun getDataBase(context: Context):AppDataBase{
            val tempInstance = INSTANCE
            if (tempInstance !=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "app_database"
                ).build()
                INSTANCE=instance
                return instance
            }
        }

    }

}
package com.pngzfoo.contractmanagerapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1)
abstract class UserDatabase : RoomDatabase(){

    abstract  val userDAO: UserDAO

    //singleton
    companion object{

        @Volatile // makes the field immediately made visible to other threads
        private var INSTANCE: UserDatabase? = null
        fun getInstance(context: Context):UserDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    //creating the database object
                    instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "users_db"
                    ).build()
                }
                INSTANCE = instance
                return instance
            }
        }
    }

}
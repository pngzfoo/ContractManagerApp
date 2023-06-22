package com.pngzfoo.contractmanagerapp.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user") //if table name didn't declare, class name will be the table name
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "userId")
    val id:Int,

    @ColumnInfo(name = "user_name")
    var name:String,

    @ColumnInfo(name = "email_name")
    var email:String
)

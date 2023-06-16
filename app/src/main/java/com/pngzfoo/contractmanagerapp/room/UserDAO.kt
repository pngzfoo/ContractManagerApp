package com.pngzfoo.contractmanagerapp.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {

    @Insert
    suspend fun insertUser(user: User):Long//suspend is a keyword that use for executing a long running operation and wait until complete(coroutine)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user")
    suspend fun deleteAll()

    @Query("SELECT * FROM user")
    fun getAllUserInDB():LiveData<List<User>>

}
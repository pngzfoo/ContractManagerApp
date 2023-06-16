package com.pngzfoo.contractmanagerapp.room

class UserRepository (private val dao: UserDAO){ //the repository is not a part of architecture component libraries, but it suggests best practices for code separation and architecture
    //repository class provides a clean API for data access to the rest of the application
    //repository manages queries and allow you to use multiple backends

    val users = dao.getAllUserInDB()

    suspend fun insert(user: User):Long{
        return dao.insertUser(user)
    }

    suspend fun delete(user: User) {
        return dao.deleteUser(user)
    }

    suspend fun update(user:User){
        return dao.updateUser(user)
    }

    suspend fun deleteAll(){
        return dao.deleteAll()
    }
}
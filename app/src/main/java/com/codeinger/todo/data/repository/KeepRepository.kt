package com.codeinger.todo.data.repository

import androidx.lifecycle.LiveData
import com.codeinger.todo.data.model.Keep
import com.codeinger.todo.data.room.dao.KeepDao
import javax.inject.Inject

class KeepRepository @Inject constructor(private val keepDao: KeepDao){

    val readAllData: LiveData<List<Keep>> = keepDao.readAllData()

    suspend fun addKeep(keep: Keep){
        keepDao.addKeep(keep)
    }

    suspend fun updateKeep(keep: Keep){
        keepDao.updateKeep(keep)
    }

    suspend fun deleteKeep(keep: Keep){
        keepDao.deleteKeep(keep)
    }

    suspend fun deleteAllKeeps(){
        keepDao.deleteAllKeeps()
    }

}
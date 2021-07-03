package com.codeinger.todo.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinger.todo.data.model.Keep

@Dao
interface KeepDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addKeep(keep: Keep)

    @Update
    suspend fun updateKeep(keep: Keep)

    @Delete
    suspend fun deleteKeep(keep: Keep)

    @Query("DELETE FROM keep_table")
    suspend fun deleteAllKeeps(): Int

    @Query("SELECT * FROM keep_table ORDER BY kid ASC")
    fun readAllData(): LiveData<List<Keep>>
}
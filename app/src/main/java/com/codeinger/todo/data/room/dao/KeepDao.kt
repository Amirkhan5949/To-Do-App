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

    @Query("DELETE FROM Keep")
    suspend fun deleteAllKeeps(): Int

    @Query("SELECT * FROM Keep Where Cid = :Cid")
      fun getAllParticularKeep (Cid : Int) : List<Keep>

    @Query("SELECT * FROM Keep ORDER BY kid ASC")
      fun readAllData(): LiveData<List<Keep>>
}
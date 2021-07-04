package com.codeinger.todo.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinger.todo.data.model.Category

@Dao
interface CaregoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategoryName(category: Category)

    @Update
    suspend fun updateCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)


    @Query("DELETE FROM Category")
    suspend fun deleteAllCategories(): Int



    @Query("SELECT * FROM Category ORDER BY Cid ASC")
    fun readAllData(): LiveData<List<Category>>
 }
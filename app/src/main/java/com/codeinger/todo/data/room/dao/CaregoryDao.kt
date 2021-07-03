package com.codeinger.todo.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codeinger.todo.data.model.Category
import com.codeinger.todo.data.model.relation.CategoryAndKeep

@Dao
interface CaregoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategoryName(category: Category)

    @Update
    suspend fun updateCategory(category: Category)

    @Delete
    suspend fun deleteCategory(category: Category)


    @Query("DELETE FROM category_table")
    suspend fun deleteAllCAtegories(): Int


    @Transaction
    @Query( "SELECT * FROM category_table Where Cid = :Cid")
    suspend fun getCategoryAndKeepWithCid (Cid : Int): List<CategoryAndKeep>

    @Query("SELECT * FROM category_table ORDER BY Cid ASC")
    fun readAllData(): LiveData<List<Category>>
 }
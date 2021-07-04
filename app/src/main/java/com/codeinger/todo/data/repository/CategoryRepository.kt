package com.codeinger.todo.data.repository

import androidx.lifecycle.LiveData
import com.codeinger.todo.data.model.Category
import com.codeinger.todo.data.room.dao.CaregoryDao
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val categoryDao: CaregoryDao){

    val readAllData: LiveData<List<Category>> = categoryDao.readAllData()
    suspend fun insertCategoryName(category: Category){
        categoryDao.insertCategoryName(category)
    }

    suspend fun updateCategory(category: Category){
        categoryDao.updateCategory(category)
    }

    suspend fun deleteCategory(category: Category){
        categoryDao.deleteCategory(category)
    }

    suspend fun deleteAllCategories(){
        categoryDao.deleteAllCategories()
    }


}
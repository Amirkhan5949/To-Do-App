package com.codeinger.todo.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinger.todo.data.model.Category
import com.codeinger.todo.data.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CategoryViewmodel @Inject constructor(var categoryRepository: CategoryRepository): ViewModel(){

    val readAllData: LiveData<List<Category>> = categoryRepository.readAllData


    fun insertCategoryName(category: Category){
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.insertCategoryName(category)
        }


    }

    fun updateCategory(category: Category){
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.updateCategory(category)
        }
    }

    fun deleteCategory(category: Category){
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.deleteCategory(category)
        }
    }

    fun deleteAllCategories(){
        viewModelScope.launch(Dispatchers.IO) {
            categoryRepository.deleteAllCategories()
        }
    }

}
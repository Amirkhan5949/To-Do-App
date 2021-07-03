package com.codeinger.todo.data.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinger.todo.data.model.Keep
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class KeepRepository @Inject constructor(var keepRepository: KeepRepository): ViewModel() {

    val readAllData: LiveData<List<Keep>> = keepRepository.readAllData

    fun addKeep(keep: Keep){
        viewModelScope.launch(Dispatchers.IO) {
            keepRepository.addKeep(keep)
        }


    }

    fun updateKeep(keep: Keep){
        viewModelScope.launch(Dispatchers.IO) {
            keepRepository.updateKeep(keep)
        }
    }

    fun deleteKeep(keep: Keep){
        viewModelScope.launch(Dispatchers.IO) {
            keepRepository.deleteKeep(keep)
        }
    }

    fun deleteAllKeep(){
        viewModelScope.launch(Dispatchers.IO) {
            keepRepository.deleteAllKeep()
        }
    }


}
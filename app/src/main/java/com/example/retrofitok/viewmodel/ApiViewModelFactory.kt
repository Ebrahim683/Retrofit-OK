package com.example.retrofitok.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitok.repository.ApiRepository

class ApiViewModelFactory(private val apiRepository: ApiRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ApiViewModel(apiRepository) as T
    }
}
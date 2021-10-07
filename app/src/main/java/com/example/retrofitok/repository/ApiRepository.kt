package com.example.retrofitok.repository

import com.example.retrofitok.api.ApiService
import com.example.retrofitok.utils.result

class ApiRepository(private val apiService: ApiService) {
    
    fun getData() = result {
        apiService.getApi()
    }

}
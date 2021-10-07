package com.example.retrofitok.viewmodel

import androidx.lifecycle.ViewModel
import com.example.retrofitok.api.ApiService
import com.example.retrofitok.api.RetrofitClient
import com.example.retrofitok.model.ApiModel
import com.example.retrofitok.repository.ApiRepository
import com.example.retrofitok.utils.ApiResponse
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import java.lang.Exception

class ApiViewModel(private val apiRepository: ApiRepository):ViewModel() {
    
    val data = apiRepository.getData()
    
//    fun getPost() = flow<ApiResponse<ApiModel>> {
//        emit(ApiResponse.Loading)
//
//        try {
//            val retrofit = RetrofitClient.getInstance()
//
//        }catch (e:Exception){
//            e.printStackTrace()
//            emit(ApiResponse.Failure(e.localizedMessage.toString()))
//        }
//
//    }
    
}
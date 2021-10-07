package com.example.retrofitok.api

import com.example.retrofitok.model.ApiModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    
    @GET("posts")
    suspend fun getApi():Response<List<ApiModel>>
}
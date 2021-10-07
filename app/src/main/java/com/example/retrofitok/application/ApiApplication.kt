package com.example.retrofitok.application

import android.app.Application
import android.util.Log
import com.example.retrofitok.api.ApiService
import com.example.retrofitok.api.RetrofitClient
import com.example.retrofitok.repository.ApiRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

const val TAG = "ApiApplication"
class ApiApplication : Application() {

lateinit var apiRepository: ApiRepository
    
    override fun onCreate() {
        super.onCreate()
        
    }
    
    private val applicationScope = CoroutineScope(SupervisorJob())
    
    val apiService by lazy {
        Log.d(TAG, "Creating Api........")
        RetrofitClient.getInstance().create(ApiService::class.java)
    }
    
    val repository by lazy {
        Log.d(TAG, "onCreate: Initializing Repository.......")
        ApiRepository(apiService)
    }
    
    fun initialize(){
        val apiService =RetrofitClient.getInstance().create(ApiService::class.java)
        apiRepository = ApiRepository(apiService)
    }

}
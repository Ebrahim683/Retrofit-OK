package com.example.retrofitok.utils

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

const val TAG = "Constant"
fun<T> result(call:suspend () -> Response<T>):Flow<ApiResponse<T>> = flow {
    
    emit(ApiResponse.Loading)
    
    try {
        val c = call()
        c.let {response->
            if (c.isSuccessful){
                emit(ApiResponse.Success(response.body()))
            }else{
               c.errorBody().let {error->
                   error!!.close()
                   emit(ApiResponse.Failure(error.toString()))
               }
            }
        }
        
    }catch (e:Exception){
        Log.d(TAG, "result: ${e.message}")
        
    }
    
}
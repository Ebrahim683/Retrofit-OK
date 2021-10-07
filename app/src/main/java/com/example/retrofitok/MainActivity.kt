package com.example.retrofitok

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitok.adapter.RecyclerAdapter
import com.example.retrofitok.application.ApiApplication
import com.example.retrofitok.model.ApiModel
import com.example.retrofitok.utils.ApiResponse
import com.example.retrofitok.viewmodel.ApiViewModel
import com.example.retrofitok.viewmodel.ApiViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val TAG = "mainActivityResponse"

class MainActivity : AppCompatActivity() {
    
    //   lateinit var viewModel: ApiViewModel
    lateinit var recAdapter: RecyclerAdapter
    private val viewModel by viewModels<ApiViewModel> {
        ApiViewModelFactory(
            (application as ApiApplication).repository
        )
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        runBlocking {
//            viewModel.data.collect { response ->
//                when (response) {
//                    is ApiResponse.Failure -> Log.d(TAG, "loadData: ${response.message}")
//                    ApiResponse.Loading -> Log.d(TAG, "loadData: Loading")
//                    is ApiResponse.Success -> Log.d(TAG, "loadData: ${response.data}")
//                }
//            }
//        }

        recyclerView()
        loadData()
//        val arrayList: ArrayList<ApiModel> = ArrayList()
//        arrayList.add(ApiModel(1, "This is body", "This is title"))
//        recAdapter.setData(arrayList)
        
    }
    
    private fun loadData() {
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.data.collect { response ->
                when (response) {
                    is ApiResponse.Failure -> Log.d(TAG, "loadData: ${response.message}")
                    is ApiResponse.Loading -> Log.d(TAG, "loadData: Loading")
                    is ApiResponse.Success -> {
                        Log.d(TAG, "loadData: ${response.data}")
                        withContext(Dispatchers.Main) {
//                            tv.text = response.data.toString()
                            recAdapter.setData(response.data as ArrayList<ApiModel>)
                        }
                    }
                }
            }
        }
    }


    private fun recyclerView() {
        recAdapter = RecyclerAdapter(this, ArrayList())
        val layout = LinearLayoutManager(this)
        recID.apply {
            setHasFixedSize(true)
            layoutManager = layout
            adapter = recAdapter
        }
    }
    
    
}
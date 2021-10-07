package com.example.retrofitok.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitok.R
import com.example.retrofitok.model.ApiModel

class RecyclerAdapter(private val context: Context, private var arrayList: ArrayList<ApiModel>) :
    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

//    private  var arrayList = ArrayList<ApiModel>()
    
    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var sample_id: TextView = itemView.findViewById(R.id.sample_id)
        var sample_title: TextView = itemView.findViewById(R.id.sample_title)
        var sample_body: TextView = itemView.findViewById(R.id.sample_body)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.single_row, parent, false)
        return RecyclerViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val apiModel = arrayList[position]
        holder.sample_id.text = apiModel.id.toString()
        holder.sample_title.text = apiModel.title
        holder.sample_body.text = apiModel.body
    }
    
    override fun getItemCount() = arrayList.size
    
    fun setData(arrayList: ArrayList<ApiModel>) {
        this.arrayList = arrayList
        notifyDataSetChanged()
    }
}
package com.example.assignment3.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment3.model.Result

class Adapter(
    private val listenerEventClick: RecyclerClick,
    private val myList: MutableList<Result> = mutableListOf()
) : RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

}
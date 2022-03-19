package com.example.assignment3.adapter

import java.util.*

class Adapter(
    private val listenerEventClick: RecyclerClick,
    private val myList: MutableList<EventModel> = mutableListOf()
) : RecyclerClick.Adapter<Adapter.ViewHolder>(){


    override fun onCreateViewHolder{

    }




}
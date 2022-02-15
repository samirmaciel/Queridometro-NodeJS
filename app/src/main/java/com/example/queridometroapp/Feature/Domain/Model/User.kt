package com.example.queridometroapp.Feature.Domain.Model

import com.example.queridometroapp.R

data class User(
    val id : Int,
    val name : String,
    var emojis : MutableList<Int> = mutableListOf(0,0,0,0,0,0)
)



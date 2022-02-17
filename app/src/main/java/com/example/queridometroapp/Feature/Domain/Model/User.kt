package com.example.queridometroapp.Feature.Domain.Model

import com.example.queridometroapp.R
import java.lang.reflect.Array

data class User(
    val id: Int = 0,
    val name: String,
    var emojis: MutableList<Int>
)



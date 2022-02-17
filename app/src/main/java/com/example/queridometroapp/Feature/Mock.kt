package com.example.queridometroapp.Feature

import android.util.Log
import com.example.queridometroapp.Feature.Domain.Model.User
import com.example.queridometroapp.R

object Mock {

    fun getUsersList() : MutableList<User>{
        return mutableListOf(
            User(0, "Fulano",  emojis = mutableListOf(2,4,6,4,8,10)),
            User(0, "Siclano", emojis = mutableListOf(2,4,6,4,8,10)),
            User(0, "Beltrano", emojis = mutableListOf(2,4,6,4,8,10)),
            User(0, "Trajano", emojis = mutableListOf(2,4,6,4,8,10)),
            User(0, "Jobilson", emojis = mutableListOf(2,4,6,4,8,10)),
            User(0, "Hermano", emojis = mutableListOf(2,4,6,4,8,10)),
            User(0, "Neymar", emojis = mutableListOf(2,4,6,4,8,10))
        )
    }

    fun getMapDrawbles() : Map<Int, Int>{
        return mapOf(
            R.drawable.bomba to 0,
            R.drawable.coracao to 1,
            R.drawable.sorriso to 2,
            R.drawable.triste to 3,
            R.drawable.planta to 4,
            R.drawable.cobra to 5,
        )
    }

}
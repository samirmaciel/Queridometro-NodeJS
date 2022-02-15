package com.example.queridometroapp.Feature

import com.example.queridometroapp.Feature.Domain.Model.User

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
}
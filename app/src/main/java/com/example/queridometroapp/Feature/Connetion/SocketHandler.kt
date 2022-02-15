package com.example.queridometroapp.Feature.Connetion

import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

object SocketHandler {

    lateinit var mSocket : Socket


    init {
        setSocket()
    }

    @Synchronized
    fun setSocket(){

        try{
            mSocket = IO.socket("http://192.168.0.10:3000")
        }catch (e: URISyntaxException){

        }
    }

    @Synchronized
    fun getSocket() : Socket{
        return mSocket
    }
}
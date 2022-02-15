package com.example.queridometroapp.Feature.Modules.HomeScreen

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.queridometroapp.Feature.Connetion.SocketHandler
import io.socket.client.Socket
import kotlinx.coroutines.launch
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class HomeScreenViewModel : ViewModel(){

    lateinit var socketConnection : Socket
    private var connection : Socket? = null
    var checkConnection : MutableLiveData<String> = MutableLiveData()
    var userName : String = "Default"

    var userList : MutableLiveData<MutableList<String>> = MutableLiveData(mutableListOf())

    init {
        socketConnection = SocketHandler.getSocket()
        setListeners()
        connect()
    }

    private fun connect(){
        socketConnection.connect()
    }

    fun registerUserName(){
        socketConnection.emit("registerUser", userName )
    }

    fun setListeners(){

        socketConnection.on("usersUpdate") { args ->
            if(args.size > 0){

            }
            Log.e("SOCKETFUCK", "setListeners: " )
        }

        socketConnection.emit("json", "FOIFOI")

        socketConnection.on("usersUpdate") { args ->
            Log.e("SOCKETFUCK", "setListeners: " + args[0].toString() )
        }

    }


}
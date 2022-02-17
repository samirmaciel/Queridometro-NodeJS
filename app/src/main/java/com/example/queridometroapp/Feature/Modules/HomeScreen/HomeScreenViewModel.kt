package com.example.queridometroapp.Feature.Modules.HomeScreen

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.queridometroapp.Feature.Connetion.SocketHandler
import com.example.queridometroapp.Feature.Domain.Model.User
import com.example.queridometroapp.Feature.GetJson
import io.socket.client.Socket
import org.json.JSONObject

@RequiresApi(Build.VERSION_CODES.N)
class HomeScreenViewModel : ViewModel(){

    var socketConnection : Socket = SocketHandler.getSocket()
    var usersConnectedCheck : MutableLiveData<Int> = MutableLiveData(0)
    var userName : String = "Default"
    var emojiSelected : MutableLiveData<Int> = MutableLiveData(0)
    var userList : MutableLiveData<MutableList<User>> = MutableLiveData(mutableListOf())

    init {
        setListeners()
        connect()
    }

    private fun connect(){
        socketConnection.connect()
    }

    fun registerUserName(){
        socketConnection.emit("registerUser", userName )
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun setListeners(){

        socketConnection.on("usersUpdate") { args ->
            val json = GetJson.getMap(args[0].toString())
            Log.d("SOCKETFUCK", "setListeners: " + json.toString())
            val d : Map<String, Object> = json as Map<String, Object>

            var tempList = mutableListOf<User>()
            d.forEach { s, p ->
                var e = GetJson.getArray(p.toString())
                val user = User(
                    name = s,
                    emojis = e.toMutableList()
                )
                tempList.add(user)
            }
            userList.postValue(tempList)
            usersConnectedCheck.postValue(tempList.size)
        }
    }

    fun sendEmojiToUser(userMap : Map<String, List<Int>>){
        socketConnection.emit("sendEmojiForUser", JSONObject(userMap.toString()))
    }
}
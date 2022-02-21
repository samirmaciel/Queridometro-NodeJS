package com.example.queridometroapp.Feature.Modules.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.queridometroapp.Feature.Domain.Model.User
import com.example.queridometroapp.R

class UsersCarouselRecyclerViewAdapter(val userClick : (String, Int) -> Unit, val userConnectedName : String) : RecyclerView.Adapter<UsersCarouselRecyclerViewAdapter.MyViewHolder>() {

    var itemList = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(position % itemList.size, userClick)
    }

    override fun getItemCount(): Int {
        return if(itemList == null) 0 else Int.MAX_VALUE
    }

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(position : Int, userClcik: (String, Int) -> Unit){
                itemView.findViewById<ImageView>(R.id.ivUserAvatar).setOnClickListener{
                    if(!itemList[position].name.equals(userConnectedName)){
                        Log.d("SocketFuck", "bindItem: " + userConnectedName)
                            userClick(itemList[position].name, position)
                        }
                }

                itemView.findViewById<TextView>(R.id.tvUserName).text = itemList[position].name
                itemView.findViewById<TextView>(R.id.tvCountBomb).text = itemList[position].emojis[0].toString()
                itemView.findViewById<TextView>(R.id.tvCountHert).text = itemList[position].emojis[1].toString()
                itemView.findViewById<TextView>(R.id.tvCountSmile).text = itemList[position].emojis[2].toString()
                itemView.findViewById<TextView>(R.id.tvCountSad).text = itemList[position].emojis[3].toString()
                itemView.findViewById<TextView>(R.id.tvCountPlant).text = itemList[position].emojis[4].toString()
                itemView.findViewById<TextView>(R.id.tvCountSnake).text = itemList[position].emojis[5].toString()
        }

    }
}
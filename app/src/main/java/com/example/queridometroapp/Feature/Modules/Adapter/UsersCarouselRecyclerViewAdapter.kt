package com.example.queridometroapp.Feature.Modules.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.queridometroapp.Feature.Domain.Model.User
import com.example.queridometroapp.R

class UsersCarouselRecyclerViewAdapter : RecyclerView.Adapter<UsersCarouselRecyclerViewAdapter.MyViewHolder>() {

    var itemList = mutableListOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(itemList[position % itemList.size])
    }

    override fun getItemCount(): Int {
        return if(itemList == null) 0 else Int.MAX_VALUE
    }

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(user : User){

                itemView.findViewById<TextView>(R.id.tvUserName).text = user.name
                itemView.findViewById<TextView>(R.id.tvCountBomb).text = user.emojis[0].toString()
                itemView.findViewById<TextView>(R.id.tvCountHert).text = user.emojis[1].toString()
                itemView.findViewById<TextView>(R.id.tvCountSmile).text = user.emojis[2].toString()
                itemView.findViewById<TextView>(R.id.tvCountSad).text = user.emojis[3].toString()
                itemView.findViewById<TextView>(R.id.tvCountPlant).text = user.emojis[4].toString()
                itemView.findViewById<TextView>(R.id.tvCountSnake).text = user.emojis[5].toString()


        }

    }
}
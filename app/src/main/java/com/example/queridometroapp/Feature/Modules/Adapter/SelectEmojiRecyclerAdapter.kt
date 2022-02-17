package com.example.queridometroapp.Feature.Modules.Adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.queridometroapp.Feature.Domain.Model.Emoji
import com.example.queridometroapp.R

class SelectEmojiRecyclerAdapter(val itemClick : (Int) -> Unit, val itemList : List<Emoji>, val context : Context) : RecyclerView.Adapter<SelectEmojiRecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rvemoji, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItem(position, itemClick)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val emojiIcon = itemView.findViewById<ImageView>(R.id.ivEmoji)
        val cardView = itemView.findViewById<CardView>(R.id.cardViewEmoji)

         fun bindItem(position : Int, itemClick: (Int) -> Unit){
             emojiIcon.setImageResource(itemList[position].drawableID)

             if(itemList[position].isSelected){
                 cardView.setCardBackgroundColor(context.resources.getColor(R.color.blue))
             }else{
                 cardView.setCardBackgroundColor(context.resources.getColor(R.color.white))
             }

             cardView.setOnClickListener{
                 if(!itemList[position].isSelected){
                     cardView.setCardBackgroundColor(context.resources.getColor(R.color.blue))
                     itemList[position].isSelected= true
                     itemClick(itemList[position].drawableID)
                     itemList.forEach{
                         if(itemList[position].drawableID != it.drawableID){
                             it.isSelected = false
                         }

                         notifyDataSetChanged()
                     }

                 }else{
                     cardView.setCardBackgroundColor(context.resources.getColor(R.color.white))
                     itemList[position].isSelected = false
                 }

             }
         }
     }
}
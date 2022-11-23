package com.example.tictactoe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val listener:RowClickListener): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private var statsList = mutableListOf<Stats>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(itemView,listener)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = statsList[position]
        holder.img.setImageResource(currentItem.winningImage)
        holder.txt0.text=currentItem.players
        holder.txt1.text=currentItem.player_x
        holder.txt2.text=currentItem.player_y
        holder.itemView.setOnClickListener{
            listener.onItemClickListener(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return statsList.size
    }
    fun setData(list:List<Stats>){
        statsList.apply{
            clear()
            addAll(list)
        }
    }

    class MyViewHolder(itemView : View , val listener :RowClickListener) :RecyclerView.ViewHolder(itemView){
        val img:ShapeableImageView = itemView.findViewById(R.id.win_img)
        val txt0:TextView =itemView.findViewById(R.id.text_0)
        val txt1:TextView =itemView.findViewById(R.id.text_1)
        val txt2:TextView =itemView.findViewById(R.id.text_2)
    }

    interface RowClickListener {
        fun onItemClickListener(user:Stats)
    }
}
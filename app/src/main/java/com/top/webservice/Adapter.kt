package com.top.webservice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView


class Adapter(
    private val reviewList: MutableList<Data>
) : RecyclerView.Adapter<Adapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rvreviews,parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        return holder.bindView(reviewList[position])
    }

    override fun getItemCount(): Int {

        return reviewList.size
    }

    public class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val Nom: TextView = itemView.findViewById(R.id.txtNom2)
        val id: TextView = itemView.findViewById(R.id.txtID)
        fun bindView(postModel: Data){
            Nom.text = postModel.nombre
            id.text = postModel.id.toString()
        }


    }
}

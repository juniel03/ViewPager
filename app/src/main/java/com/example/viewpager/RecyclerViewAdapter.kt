package com.example.viewpager

import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerViewAdapter (val menuItem: List<Item> , val title: ArrayList<String>, val description: ArrayList<String>, val logo: ArrayList<String>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyView>() {

    class MyView(view: View) : RecyclerView.ViewHolder(view){
        var textviewTitle: TextView
        var textViewDesc: TextView
        var imageLogo: ImageView
        init {
            textviewTitle = view
                .findViewById<TextView>(R.id.itemTvTitle)
            textViewDesc = view
                .findViewById<TextView>(R.id.itemTvDescription)
            imageLogo = view
                .findViewById<ImageView>(R.id.itemIvLogo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.MyView {
        val itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_page,
                parent,
                false
            )
        return MyView(itemView)
    }

    override fun getItemCount(): Int {
        return menuItem.size

    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val listData = logo[position]
        holder.textviewTitle.setText(title[position])
        holder.textViewDesc.setText(description[position])
        Picasso.get().load(listData).placeholder(R.mipmap.ic_launcher).into(holder.imageLogo)
    }

}
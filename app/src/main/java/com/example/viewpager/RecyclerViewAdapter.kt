package com.example.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerViewAdapter (private val menuItem: List<Item>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyView>() {



    inner class MyView(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
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
            view.setOnClickListener(this)
        }
        override fun onClick(v: View?) {
            val position = adapterPosition
            val item = menuItem[position]
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position, item)
            }
        }
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int ,item: Item)
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
        holder.textviewTitle.text = menuItem[position].title
        holder.textViewDesc.text = menuItem[position].description
        Picasso.get().load(menuItem[position].image).placeholder(R.mipmap.ic_launcher).into(holder.imageLogo)
    }

}
package com.example.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter : RecyclerView.Adapter<PagerVH>() {

    private val colors = intArrayOf(
        android.R.color.black,
        android.R.color.holo_red_light,
        android.R.color.holo_blue_dark,
        android.R.color.holo_purple
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false)
        return PagerVH(v).apply {
            textViewTitle = v.findViewById(R.id.itemTvTitle)
            // and any other views you need to set up
        }
    }

    override fun getItemCount(): Int = colors.size

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        // now the reference is a field on the ViewHolder
        holder.textViewTitle.text = "item $position"
    }
}
class PagerVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    lateinit var textViewTitle : TextView
}
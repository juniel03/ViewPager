package com.example.viewpager

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.properties.Delegates

class DrinksAdapter(private val drinksItem: List<Drink>, private val listener:OnRadioChangeListener) : RecyclerView.Adapter<DrinksAdapter.DrinksViewHolder>() {

    public var mSelectedItem = -1

    interface OnRadioChangeListener{
        fun onRadioChange(position: Int ,drink: Drink)
    }


    inner class DrinksViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var drinkradioButton: RadioButton
        var drinkDesc: TextView
        init {
            drinkradioButton = view
                    .findViewById<RadioButton>(R.id.drinkRadio)
            drinkDesc = view
                    .findViewById<TextView>(R.id.drinkDesc)
            drinkradioButton.setOnClickListener {
                val position = adapterPosition
                mSelectedItem = getAdapterPosition()
                Log.d("tag", "click ${drinksItem.get(mSelectedItem)}")
                listener.onRadioChange(position, drinksItem[mSelectedItem])
                notifyDataSetChanged()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinksViewHolder {
        val itemView: View = LayoutInflater
                .from(parent.context)
                .inflate(
                        R.layout.drinks,
                        parent,
                        false
                )
        return DrinksViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return drinksItem.size
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        holder.drinkDesc.setText(drinksItem[position].desc)
        holder.drinkradioButton.setText(drinksItem[position].Category)
        holder.drinkradioButton.setChecked(position == mSelectedItem)
    }

    var selectedPosition by Delegates.observable(-1) { property, oldPos, newPos ->
        if (newPos in drinksItem.indices) {
            notifyItemChanged(oldPos)
            notifyItemChanged(newPos)
        }
    }
}
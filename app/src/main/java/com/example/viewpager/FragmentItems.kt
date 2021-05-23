package com.example.viewpager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class FragmentItems : Fragment(), RecyclerViewAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_items, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val menu: Menu
        arguments?.let {
            val rec = view.findViewById<RecyclerView>(R.id.recycler)
            rec.layoutManager = LinearLayoutManager(activity)
             menu = it.getParcelable("menu")!!
            val menuItem: List<Item> = menu.items
            rec.adapter = RecyclerViewAdapter(menuItem, this)
        }
    }

    override fun onItemClick(position: Int, item: Item) {
        Toast.makeText(activity, "position $position , Item Title = ${item.title}, Item description = ${item.description}, Item Image = ${item.image}", Toast.LENGTH_SHORT).show()
    }
}
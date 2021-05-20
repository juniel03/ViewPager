package com.example.viewpager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONObject

class FragmentItems : Fragment() {


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
        val titles: ArrayList<String> = ArrayList()
        val descriptions: ArrayList<String> = ArrayList()
        val logo: ArrayList<String> = ArrayList()

        arguments?.let {
            val rec = view.findViewById<RecyclerView>(R.id.recycler)
            rec.layoutManager = LinearLayoutManager(activity)
            val menu: Menu = it.getParcelable("menu")!!
            val menuItem: List<Item> = menu.items
            val items: ArrayList<String> = it.getStringArrayList("list") as ArrayList<String>
            for (item in items) {
                val jsonObject = JSONObject(item)
                Log.d("tag", "adaper json item: $jsonObject")
                titles.add(jsonObject.getString("title"))
                descriptions.add(jsonObject.getString("description"))
                logo.add(jsonObject.getString("image"))
            }

            Log.d("tag", "title: $titles, description $descriptions")
            rec.adapter = RecyclerViewAdapter(menuItem, titles, descriptions, logo)
        }
    }
}
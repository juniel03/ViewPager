package com.example.viewpager

import android.util.Log
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import org.json.JSONObject


class ViewPagerFragmentAdapter(var menuItems: ArrayList<Menu>,fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager,lifecycle) {

    override fun getItemCount(): Int = menuItems.size

    override fun createFragment(position: Int): Fragment = FragmentItems().apply {
        arguments = bundleOf(
            "menu" to menuItems[position]
        )
    }
}
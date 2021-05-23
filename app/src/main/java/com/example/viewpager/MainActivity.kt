package com.example.viewpager

import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.viewpager.databinding.ActivityMainBinding
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var menuList = ArrayList<Menu>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val json = this.assets.readFile("complicated_menu.json")
        val category = jsonConvert(json)
        Log.d("tag", "category ${category.menu.size}")
        for (menuItem in category.menu){
            menuList.add(menuItem)
        }
        binding.viewPager2.adapter = ViewPagerFragmentAdapter(menuList, supportFragmentManager, lifecycle)
    }

    fun AssetManager.readFile(fileName: String) = open(fileName)
        .bufferedReader()
        .use { it.readText()
        }

    fun jsonConvert(jsonString: String) : Category {
        return Gson().fromJson(jsonString, Category::class.java)
    }
}
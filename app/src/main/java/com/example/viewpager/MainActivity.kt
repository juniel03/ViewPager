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
    var listdata = ArrayList<ArrayList<String>>()
    var menuList = ArrayList<Menu>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val json = this.assets.readFile("complicated_menu.json")
        val compjson = this.assets.readFile("complicated_menu.json")
        val jsonObject = JSONObject(json)
        val compjsonObject = JSONObject(compjson)
        val category = jsonConvert(json)
        Log.d("tag", "category ${category.menu.size}")
        val menuArray = jsonObject.getJSONArray("menu")
        for (i in 0 until menuArray.length()) {
            val menudetail = menuArray.getJSONObject(i)
            val jArray = menudetail.getJSONArray("items")
            val aray: ArrayList<String> = ArrayList()
            for (i in 0 until jArray.length()) {
                aray.add(jArray.getString(i))
            }
            listdata.add(aray)
        }
        for (menuItem in category.menu){
            menuList.add(menuItem)
        }

        binding.viewPager2.adapter = ViewPagerFragmentAdapter(menuList,listdata, supportFragmentManager, lifecycle)
    }

    fun AssetManager.readFile(fileName: String) = open(fileName)
        .bufferedReader()
        .use { it.readText()
        }

    fun jsonConvert(jsonString: String) : Category {
        return Gson().fromJson(jsonString, Category::class.java)
    }
}
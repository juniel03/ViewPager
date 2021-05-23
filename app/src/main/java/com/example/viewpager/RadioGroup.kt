package com.example.viewpager

import android.content.res.AssetManager
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viewpager.databinding.ActivityRadioGroupBinding
import com.google.gson.Gson


class RadioGroup : AppCompatActivity(), DrinksAdapter.OnRadioChangeListener {

    private lateinit var binding: ActivityRadioGroupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRadioGroupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.drinksRec.layoutManager = LinearLayoutManager(this)

        val json = this.assets.readFile("menu.json")
        val category = jsonConvert(json)
        Log.d("tag", "category: $category")
        val drinkItems: List<Drink> = category.drinks
        binding.drinksRec.adapter = DrinksAdapter(drinkItems, this)
        binding.button.setOnClickListener {

        }
    }

    fun AssetManager.readFile(fileName: String) = open(fileName)
            .bufferedReader()
            .use { it.readText()
            }

    fun jsonConvert(jsonString: String) : drinksModel {
        return Gson().fromJson(jsonString, drinksModel::class.java)
    }

    override fun onRadioChange(position: Int, drink: Drink) {
        Log.d("tag", "position: $position, drink $drink")
    }
}
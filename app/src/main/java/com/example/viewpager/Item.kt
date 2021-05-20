package com.example.viewpager

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    val description: String,
    val image: String,
    val title: String
): Parcelable
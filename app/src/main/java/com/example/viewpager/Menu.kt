package com.example.viewpager

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
@Parcelize
data class Menu(
    val Category: String,
    val items: List<Item>
): Parcelable
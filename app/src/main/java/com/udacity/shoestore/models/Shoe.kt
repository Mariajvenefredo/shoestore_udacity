package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    val name: String, val size: Double, val company: String, val description: String,
    @DrawableRes val imageResId: Int = 0
) : Parcelable
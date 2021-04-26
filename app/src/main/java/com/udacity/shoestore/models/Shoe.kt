package com.udacity.shoestore.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(
    var name: String, var company: String, var description: String, var size: Double,
    @DrawableRes val imageResId: Int = 0
) : Parcelable
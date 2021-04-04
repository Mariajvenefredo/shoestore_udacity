package com.udacity.shoestore.screens.shoeList

import android.app.Application
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel(application: Application) : AndroidViewModel(application) {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

    companion object {
        private const val SHOE_SIZE_FIVE = 5.0
        private const val SHOE_SIZE_SIX = 6.0
        private const val SHOE_SIZE_SEVEN = 7.0
    }

    init {
        _shoeList.value = mutableListOf(
            buildShoe(R.string.shoe_one_title, SHOE_SIZE_FIVE, R.string.company_converse, R.string.shoe_one_des, R.drawable.shoe1),
            buildShoe(R.string.shoe_two_title, SHOE_SIZE_SIX, R.string.company_nike, R.string.shoe_two_des, R.drawable.shoe2),
            buildShoe(R.string.shoe_three_title, SHOE_SIZE_FIVE, R.string.company_converse, R.string.shoe_three_des, R.drawable.shoe3),
            buildShoe(R.string.shoe_four_title, SHOE_SIZE_SEVEN, R.string.company_valentino, R.string.shoe_four_des, R.drawable.shoe4),
            buildShoe(R.string.shoe_five_title, SHOE_SIZE_SIX, R.string.company_nike, R.string.shoe_five_des, R.drawable.shoe5),
            buildShoe(R.string.shoe_six_title, SHOE_SIZE_SEVEN, R.string.company_valentino, R.string.shoe_six_des, R.drawable.shoe6)
        )
    }

    private fun buildShoe(
        @StringRes titleResId: Int,
        shoeSize: Double,
        @StringRes companyResId: Int,
        @StringRes descriptionResId: Int,
        @DrawableRes imageId: Int
    ) =
        Shoe(
            getString(titleResId),
            shoeSize,
            getString(companyResId),
            getString(descriptionResId),
            imageId
        )

    private fun getString(@StringRes resID: Int): String {
        return getApplication<Application>().resources.getString(resID)
    }
}

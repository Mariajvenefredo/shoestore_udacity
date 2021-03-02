package com.udacity.shoestore.screens.welcome

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.synnapps.carouselview.ImageListener
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {

    companion object {
        private var sampleImages = intArrayOf(
            R.drawable.shoe1,
            R.drawable.shoe2,
            R.drawable.shoe3,
            R.drawable.shoe4,
            R.drawable.shoe5,
            R.drawable.shoe6
        )
    }

    private lateinit var binding: WelcomeFragmentBinding

    private var imageListener: ImageListener =
        ImageListener { position, imageView ->
            imageView.setImageResource(sampleImages[position])
            imageView.adjustViewBounds = true
            imageView.setBackgroundColor(Color.WHITE)
            imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil
            .inflate(inflater, R.layout.welcome_fragment, container, false)

        binding.carouselView.pageCount = sampleImages.size;
        binding.carouselView.setImageListener(imageListener);

        binding
            .nextButton
            .setOnClickListener {
                findNavController()
                    .navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
            }

        return binding.root
    }
}
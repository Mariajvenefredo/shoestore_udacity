package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListFragmentBinding
import com.udacity.shoestore.databinding.ShoeListItemBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.ShoeActivityViewModel

class ShoeListFragment : Fragment() {

    private lateinit var binding: ShoeListFragmentBinding
    private lateinit var viewModel: ShoeActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil
            .inflate(inflater, R.layout.shoe_list_fragment, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeActivityViewModel::class.java)

        val shoeList = viewModel.shoeList.value

        shoeList
            ?.toList()
            ?.take(shoeList.size)
            ?.mapIndexed { _, shoe -> buildShoeItemView(inflater, shoe) }
            ?.map { b -> b.root }
            ?.forEach(binding.shoeListContainer::addView)

        binding.lifecycleOwner = this
        binding
            .addShoeButton
            .apply {
                isClickable = true
                setOnClickListener {
                    findNavController()
                        .navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
                }
            }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeActivityViewModel::class.java)
    }

    private fun buildShoeItemView(
        inflater: LayoutInflater,
        shoe: Shoe
    ): ViewBinding =
        ShoeListItemBinding
            .inflate(inflater)
            .apply {
                shoeName.text = shoe.name
                shoeCompany.text = shoe.company
                shoeDescription.text = shoe.description
                shoeSize.text = shoe.size.toString()
                shoeImage.setImageResource(shoe.imageResId)
                shoeImage.scaleType = ImageView.ScaleType.FIT_XY
            }
}
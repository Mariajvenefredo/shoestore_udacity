package com.udacity.shoestore.screens.shoeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.ShoeActivityViewModel

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: ShoeDetailFragmentBinding
    private lateinit var viewModel: ShoeActivityViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(ShoeActivityViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.shoe_detail_fragment, container, false)
        binding.lifecycleOwner = this

        binding.apply {
            cancelButton
                .setOnClickListener {
                    navigateBackToShoesScreen()
                }
            addButton
                .setOnClickListener {
                    addShoeToList()
                }
            //initialize empty shoe
            shoe = Shoe()
        }

        setShoeSizeSpinner()

        return binding.root
    }

    private fun setShoeSizeSpinner() {
        val sizes = viewModel.shoeSizes()
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, sizes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.sizeSpinner.adapter = adapter
    }

    private fun addShoeToList() {
        val size = binding.sizeSpinner.selectedItem as Double
        val shoe = binding.shoe
        shoe!!.size = size
        viewModel.onShoeAdded(shoe)

        navigateBackToShoesScreen()
    }

    private fun navigateBackToShoesScreen() =
        findNavController()
            .navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeActivityViewModel::class.java)
    }
}
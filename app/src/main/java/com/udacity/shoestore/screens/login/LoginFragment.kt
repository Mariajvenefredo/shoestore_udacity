package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        binding = DataBindingUtil
            .inflate(inflater, R.layout.login_fragment, container, false)

        binding
            .loginButton
            .setOnClickListener {
                navigateToWelcomeScreen()
            }

        binding
            .registerButton
            .setOnClickListener {
                navigateToWelcomeScreen()
            }

        return binding.root
    }

    private fun navigateToWelcomeScreen() =
        findNavController()
            .navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
}
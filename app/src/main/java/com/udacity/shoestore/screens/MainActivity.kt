package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.udacity.shoestore.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        /*
        val binding =
            DataBindingUtil
                .setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        val navController = navHostFragment.navController

        navController.let {
            it.setGraph(R.navigation.app_navigation)
            */
/*
            val appBarConfiguration =
                AppBarConfiguration(setOf(R.id.loginFragment, R.id.listFragment))

            setSupportActionBar(binding.toolbar)

            binding
                .toolbar
                .setupWithNavController(it, appBarConfiguration)

 */
    }
}
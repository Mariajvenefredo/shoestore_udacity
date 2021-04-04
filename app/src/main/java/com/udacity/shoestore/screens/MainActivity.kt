package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil
            .setContentView<MainActivityBinding>(this, R.layout.main_activity)

        val navController = this.findNavController(R.id.nav_host_fragment)

        appBarConfiguration =
            AppBarConfiguration.Builder(setOf(R.layout.login_fragment))
                .build()

        setSupportActionBar(binding.toolbar)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
        supportActionBar?.setDisplayShowTitleEnabled(false);

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.loginFragment -> {
            val navController = this.findNavController(R.id.nav_host_fragment)
            navController.popBackStack(R.id.loginFragment, true);
            navController.navigate(R.id.loginFragment);
            true
        }
        else -> false
    }
}
package com.example.deakyu.fitnessapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_diet.*

class DietActivity : AppCompatActivity() {


    companion object {

        fun newIntent(context : Context): Intent
        {
            val intent = Intent(context,DietActivity::class.java)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet)

        setSupportActionBar(toolbar)

        val host: NavHostFragment = supportFragmentManager
                .findFragmentById(R.id.host_fragment) as NavHostFragment? ?: return

        val navController = host.navController
        setupActionBar(navController)

    }

    private fun setupActionBar(navController: NavController) {

        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp()
            = findNavController(R.id.host_fragment).navigateUp()

}

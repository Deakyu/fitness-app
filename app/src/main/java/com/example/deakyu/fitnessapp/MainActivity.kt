package com.example.deakyu.fitnessapp

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.custom_dialog.view.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {

        fun newIntent(context : Context): Intent
        {
            val intent = Intent(context,MainActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_diets -> {

                //TODO: Create the layout to setup diet and put the following code in the activity related
                   createAlertDialog("Add Diet")

                //we can reuse the las alertDialog for meals
                // createAlertDialog("Add Meal")

            }
            R.id.nav_workouts -> {
                finish()
            }
            R.id.nav_profile -> {
                finish()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


//TODO: change this in an appropriate place (like in the activity related with the setup diet where we will put the fragments)
    fun createAlertDialog(title:String){

        val layout = LayoutInflater.from(this).inflate(R.layout.custom_dialog,null)
        val editTextName = layout.editTextName

        AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_input_add)
                .setTitle(title)
                .setView(layout)
                .setPositiveButton(getString(R.string.button_accept)) { dialogInterface: DialogInterface, i: Int ->

                    //TODO: make something with the string
                    Toast.makeText(this,editTextName.text.toString(), Toast.LENGTH_SHORT).show()


                }
                .setNegativeButton(getString(R.string.button_cancel),null)
                .show()
    }

}

package com.example.deakyu.fitnessapp

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_diet.*
import kotlinx.android.synthetic.main.custom_dialog.view.*


class DietActivity : AppCompatActivity() {


    companion object {

        fun newIntent(context : Context): Intent
        {
            val intent = Intent(context,DietActivity::class.java)
            return intent
        }

        fun createAlertDialog(title:String, context: Context, code:Int = 1){

            val layout = LayoutInflater.from(context).inflate(R.layout.custom_dialog,null)
            val editTextName = layout.editTextName

            AlertDialog.Builder(context)
                    .setIcon(android.R.drawable.ic_input_add)
                    .setTitle(title)
                    .setView(layout)
                    .setPositiveButton(context.getString(R.string.button_accept)) { dialogInterface: DialogInterface, i: Int ->

                        //TODO: make something with the string
                        Toast.makeText(context,editTextName.text.toString(), Toast.LENGTH_SHORT).show()


                    }
                    .setNegativeButton(context.getString(R.string.button_cancel),null)
                    .show()
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

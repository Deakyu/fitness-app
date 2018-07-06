package com.example.deakyu.fitnessapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import com.example.deakyu.fitnessapp.utils.CommonFunctions.Companion.isEmailValid
import com.example.deakyu.fitnessapp.utils.CommonFunctions.Companion.isPasswordValid
import kotlinx.android.synthetic.main.activity_register.*
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity(){

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    companion object {
        fun newIntent(context: Context): Intent
        {
            var intent = Intent(context, RegisterActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        register_button.setOnClickListener { attemptLogin() }
    }

    private fun attemptLogin() {

        // Reset errors.
        email.error = null
        password.error = null
        name.error = null
        age.error = null
        height.error = null
        weight.error = null

        // Store values at the time of the login attempt.
        val emailStr = email.text.toString()
        val passwordStr = password.text.toString()
        val nameStr = name.text.toString()
        val ageStr = age.text.toString()
        val heightStr = height.text.toString()
        val weightStr = weight.text.toString()

        var cancel = false
        var focusView: View? = null

        // Check for a valid password, if the user entered one.
        if (!passwordStr.isPasswordValid()) {
            password.error = getString(R.string.error_invalid_password)
            focusView = password
            cancel = true
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(emailStr)) {
            email.error = getString(R.string.error_field_required)
            focusView = email
            cancel = true
        } else if (!emailStr.isEmailValid()) {
            email.error = getString(R.string.error_invalid_email)
            focusView = email
            cancel = true
        }

        // Check for a name not empty.
        if (TextUtils.isEmpty(nameStr)) {
            name.error = getString(R.string.error_field_required)
            focusView = name
            cancel = true
        }


        // Check for a Age not empty.
        if (TextUtils.isEmpty(ageStr)) {
            age.error = getString(R.string.error_field_required)
            focusView = age
            cancel = true
        }

        // Check for a Height not empty.
        if (TextUtils.isEmpty(heightStr)) {
            height.error = getString(R.string.error_field_required)
            focusView = height
            cancel = true
        }


        // Check for a weight not empty.
        if (TextUtils.isEmpty(weightStr)) {
            weight.error = getString(R.string.error_field_required)
            focusView = weight
            cancel = true
        }



        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView?.requestFocus()
        } else {

            runService(emailStr, passwordStr)
        }
    }

    private fun runService(email: String, password: String)
    {
        //TODO:make call to the api

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) {
                    if(it.isSuccessful()) {
                        // Signup && Signin success, update ui with the signed-in user's information
                        var user: FirebaseUser? = mAuth.currentUser
                    } else {
                        // Signup && Signin fails, display error message
                    }
                }

        var intent = LoginActivity.newIntent(this@RegisterActivity)
        startActivity(intent)

    }


}
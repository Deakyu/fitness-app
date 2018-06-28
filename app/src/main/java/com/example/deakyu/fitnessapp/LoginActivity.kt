package com.example.deakyu.fitnessapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.example.deakyu.fitnessapp.utils.CommonFunctions
import com.example.deakyu.fitnessapp.utils.CommonFunctions.Companion.isEmailValid
import com.example.deakyu.fitnessapp.utils.CommonFunctions.Companion.isPasswordValid
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(){


    companion object {
        fun newIntent(context:Context):Intent
        {
            var intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        password.setOnEditorActionListener(TextView.OnEditorActionListener { _, id, _ ->
            if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                attemptLogin()
                return@OnEditorActionListener true
            }
            false
        })

        email_sign_in_button.setOnClickListener { attemptLogin() }
        registerlogin_button.setOnClickListener{

            var intent = RegisterActivity.newIntent(this@LoginActivity)
            startActivity(intent)
        }
    }

    private fun attemptLogin() {

        // Reset errors.
        email.error = null
        password.error = null

        // Store values at the time of the login attempt.
        val emailStr = email.text.toString()
        val passwordStr = password.text.toString()

        var cancel = false
        var focusView: View? = null

        // Check for a valid password, if the user entered one.
        if (TextUtils.isEmpty(passwordStr) || !passwordStr.isPasswordValid()) {
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

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView?.requestFocus()
        } else {

            runService()
        }
    }

    private fun runService()
    {
        //TODO:make calle to the api

        var intent = MainActivity.newIntent(this@LoginActivity)
        startActivity(intent)

    }


}

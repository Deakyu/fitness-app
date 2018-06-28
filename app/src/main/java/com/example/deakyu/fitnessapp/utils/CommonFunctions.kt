package com.example.deakyu.fitnessapp.utils


class CommonFunctions
{
    companion object {

        //TODO: Replace this with your own logic
         fun String.isEmailValid()=  this.contains("@")

        //TODO: Replace this with your own logic
         fun String.isPasswordValid() = this.length > 4

    }
}


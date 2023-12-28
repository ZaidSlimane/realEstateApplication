package com.example.realestateapplication.Model

import androidx.annotation.DrawableRes

data class Transaction(
    @DrawableRes val icon : Int,
     val date : String,
    val price : String,
    val state  : String
)

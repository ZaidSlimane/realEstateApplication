package com.example.realestateapplication.Model

import androidx.annotation.DrawableRes


data class Proprety (
    @DrawableRes val propretyIamge: Int,
    val suraface: Int,
    val places: Int,
    val kitchens : Int
)
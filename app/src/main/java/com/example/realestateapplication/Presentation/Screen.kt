package com.example.realestateapplication.Presentation

import androidx.annotation.DrawableRes
import com.example.realestateapplication.R

sealed class Screen (
    val id: Int,
    val title: String,
    @DrawableRes val selectedIcon: Int
){
    object Home:Screen(id=0,
        title = "Home",
        selectedIcon = R.drawable.ic_home)

    object Settings:Screen(
        id=3,
        title = "Settings",
        selectedIcon = R.drawable.ic_settings
    )

    object Bookmarks:Screen(
        id=1,
        title = "Bookmark",
        selectedIcon = R.drawable.ic_settings
    )

    object Payment:Screen(
        id=2,
        title = "Payment",
        selectedIcon = R.drawable.ic_settings
    )

}

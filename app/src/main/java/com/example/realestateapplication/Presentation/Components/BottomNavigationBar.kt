package com.example.realestateapplication.Presentation.Components

import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.example.realestateapplication.Presentation.Screen


@Composable
fun navItem(item: Screen, isSelected: Boolean, onClick: () -> Unit){
val iconId = item.selectedIcon
    val iconAlpha = if(isSelected) 1f else 0.5f
    IconButton(onClick = { onClick }) {
    }
}


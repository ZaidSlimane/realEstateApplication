package com.example.realestateapplication.Presentation

import android.graphics.drawable.Icon
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.selects.select



@Composable
fun navItem(item:Screen, isSelected: Boolean, onClick: () -> Unit){
val iconId = item.selectedIcon
    val iconAlpha = if(isSelected) 1f else 0.5f
    IconButton(onClick = { onClick }) {
    }
}


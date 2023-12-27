package com.example.realestateapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.realestateapplication.Presentation.PropertyDetailsScreen
import com.example.realestateapplication.Presentation.homeScreen
import com.example.realestateapplication.ui.theme.RealEstateApplicationTheme

class MainActivity : ComponentActivity() {
    val onClick: () -> Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PropertyDetailsScreen()
            RealEstateApplicationTheme {
                PropertyDetailsScreen()
               // homeScreen(userName = "Zaid Slimane", onClick)
                }
            }
        }
    }



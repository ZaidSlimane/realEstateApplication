package com.example.realestateapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.realestateapplication.Presentation.Screens.TicketComplaintScreen
import com.example.realestateapplication.Presentation.Screens.homeScreen
import com.example.realestateapplication.Presentation.Visualizer3DScreen
import com.example.realestateapplication.ui.theme.RealEstateApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val onClick: () -> Unit = {}




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            //  PropertyDetailsScreen()
            RealEstateApplicationTheme {
               // TicketComplaintScreen()
               // Visualizer3DScreen(LocalLifecycleOwner.current.lifecycle)
               //PaymentTransactionScreen()
               //Visualizer3DScreen()
               // PropertyDetailsScreen()
                homeScreen(userName = "Zaid Slimane", onClick)
                }
            }
        }
    }



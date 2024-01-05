package com.example.realestat

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.realestateapplication.Presentation.States.ScreenRoute

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreenRoute.SplashScreen.route) {
     composable(route = ScreenRoute.SplashScreen.route){
         SpashScreen(navController)
     }
     composable(ScreenRoute.OnboadingScreen.route){
         OnbordingScreen(navController = navController)
     }
        composable(ScreenRoute.LoginSreen.route){
            LoginPage(navController = navController)
        }
    }
}
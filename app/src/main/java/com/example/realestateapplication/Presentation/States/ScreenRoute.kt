package com.example.realestateapplication.Presentation.States

sealed class ScreenRoute(val route : String) {
    object SplashScreen : ScreenRoute(route = "Spalsh")
    object OnboadingScreen : ScreenRoute(route = "OnboardingScreen")
    object LoginSreen : ScreenRoute(route = "login")
}
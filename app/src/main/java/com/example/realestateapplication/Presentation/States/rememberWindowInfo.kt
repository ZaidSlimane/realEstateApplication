package com.example.realestat

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberWindowInfo() :  WindowInfo {
   val configuration = LocalConfiguration.current
    Log.d("remem", "rememberWindowInfo: H --${configuration.screenHeightDp.dp} W-- ${configuration.screenWidthDp.dp}  ")
    return WindowInfo(
        screenWidthInfo= when{
            configuration.screenWidthDp < 600 -> WindowInfo.WindowType.compact
            configuration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        } ,
        screenHeightInfo = when{
            configuration.screenHeightDp < 480 -> WindowInfo.WindowType.compact
            configuration.screenHeightDp < 900 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expanded
        } ,
        screenWidth = configuration.screenWidthDp.dp ,
        screenHeight = configuration.screenHeightDp.dp
    )
}

data class WindowInfo  (
  val screenHeightInfo: WindowType,
    val screenWidthInfo: WindowType ,
    val screenWidth: Dp ,
    val screenHeight: Dp
){
    sealed class WindowType{
        object compact: WindowType()
        object Medium: WindowType()
        object Expanded: WindowType()
    }
}
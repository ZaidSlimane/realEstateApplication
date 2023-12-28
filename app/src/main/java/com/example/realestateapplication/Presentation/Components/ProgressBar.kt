package com.example.realestateapplication.Presentation.Components

import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color



import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun CustomProgressBar() {

    val context = LocalContext.current
    var totalAmount: Int by remember { mutableStateOf(0) }
    var progress by remember { mutableStateOf(0f) }

    /* to avoid the direct calculation of progress variable which is a Float
     and it can sometimes cause problems like it shows 0.4 to 0.400004 so, here I have use
     totalAmount and we will increase and decrease it and then convert it to progress(Float)
     and then use that progress with our ProgressBar Width*/
    when (totalAmount) {
        0 -> progress = 0.0f
        1 -> progress = 0.1f
        2 -> progress = 0.2f
        3 -> progress = 0.3f
        4 -> progress = 0.4f
        5 -> progress = 0.5f
        6 -> progress = 0.6f
        7 -> progress = 0.7f
        8 -> progress = 0.8f
        9 -> progress = 0.9f
        10 -> progress = 1.0f
    }

    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 100,
            delayMillis = 100,
            easing = LinearOutSlowInEasing
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        // for the text above the progressBar
        Row(
            modifier = Modifier
                .widthIn(min = 30.dp)
                .fillMaxWidth(size),
            horizontalArrangement = Arrangement.End
        ) {
            Text(text = "$progress")
        }
        // Progress Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(5.dp)
        ) {
            // for the background of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Cyan)
            )
            // for the progress of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(9.dp))
                    .background(Color.Blue)
                    .animateContentSize()
            )
        }

    }

//    Use this when you want your progress bar should animate when you open your app
//    LaunchedEffect(key1 = true) {
//        totalAmount = 7
//    }

}
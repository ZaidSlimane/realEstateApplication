package com.example.realestateapplication.Presentation.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable()
fun textedButton(buttonText : String,
                 alignment : Alignment,
                 paddingValues: PaddingValues
){
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(paddingValues)

    ){
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color(0xFF001F3F)),
            modifier = Modifier
                .align(alignment)
                .width(166.dp)
                .height(63.dp)
                .background(
                    color = Color(0xFF001F3F),
                    shape = RoundedCornerShape(size = 10.dp),
                )
        ) {
            Text(text = buttonText)
        }
    }

}
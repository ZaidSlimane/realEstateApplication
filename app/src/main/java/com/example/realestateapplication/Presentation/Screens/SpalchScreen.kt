package com.example.realestat

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.realestateapplication.Presentation.States.ScreenRoute
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun SpashScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
      systemUiController.setStatusBarColor(Color.Transparent)
    }
    Box {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "" ,
            contentScale = ContentScale.Crop ,
            modifier = Modifier
                .blur(3.dp)
        )
        Column (
            modifier = Modifier
                .padding(top = (LocalConfiguration.current.screenHeightDp / 2.2).dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "HoldFlow" ,
                fontSize = 30.sp ,
                color = Color.White ,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height((LocalConfiguration.current.screenHeightDp / 3).dp))
            Button(
                onClick = {
                          navController.navigate(ScreenRoute.OnboadingScreen.route)
                          } ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF001F3F) ,
                ) ,
                shape = RoundedCornerShape(10.dp) ,
                modifier = Modifier
                    .width(250.dp)
            ) {
                Text(
                    text = "Let's started" ,
                    color = Color.White ,
                    fontSize = 20.sp
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "Made with Love")
            Text(text = "V.1.0" , fontWeight = FontWeight.Bold)
        }
    }
}
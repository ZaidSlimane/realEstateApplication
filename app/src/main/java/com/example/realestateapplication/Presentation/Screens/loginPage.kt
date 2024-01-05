package com.example.realestat

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.withConsumedWindowInsets
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import java.util.logging.Handler


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(navController: NavController) {
    val layoutDirection = LocalConfiguration.current.layoutDirection
    var visibility = remember {
        mutableStateOf(false)
    }
    var showPassword = if (!visibility.value) { //for show the password according to variable visible
        remember {
            mutableStateOf(PasswordVisualTransformation())
        }
    } else {
        remember {
            mutableStateOf(VisualTransformation.None)
        }
    }
    var onclick = remember< @Composable() (()->Unit)> {
        {
          LaunchedEffect(key1 = visibility.value) {
              visibility.value = !visibility.value
              delay(2000L)
              visibility.value = !visibility.value
          }
        }
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally ,
    ){
           Spacer(modifier = Modifier.height(150.dp))
            Text(
                text = "Let’s Sign In" ,
                fontSize = 35.sp ,
                color = Color.Black ,
                fontWeight = FontWeight.Bold ,
                modifier = Modifier
                    .padding(top = 40.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))
               OutlinedTextField(
                   value = "",
                   onValueChange = {

                   },
                   placeholder = {
                       Text(text = "Email")
                   },
                   colors = TextFieldDefaults.textFieldColors(
                       containerColor = Color(0xFFF5F4F8),
                       cursorColor = Color.Black,
                       textColor = Color.Black,
                       focusedIndicatorColor = Color.Transparent,
                       unfocusedIndicatorColor = Color.Transparent,
                   ) ,
                   leadingIcon = {
                       Icon(
                           imageVector = Icons.Rounded.Email,
                           contentDescription = ""  ,
                           tint = Color.Black
                       )
                   }
               )
               Spacer(modifier = Modifier.height(20.dp))
               OutlinedTextField(
                   value = "jknnjn",
                   onValueChange = {

                   },
                   placeholder = {
                       AnimatedVisibility(visible = false) {

                       }
                       Text(text = "Password")
                   },
                   colors = TextFieldDefaults.textFieldColors(
                       containerColor = Color(0xFFF5F4F8),
                       cursorColor = Color.Black,
                       textColor = Color.Black,
                       focusedIndicatorColor = Color.Transparent,
                       unfocusedIndicatorColor = Color.Transparent,
                   ),
                   leadingIcon = {
                       Icon(
                           imageVector = Icons.Rounded.Lock,
                           contentDescription = ""  ,
                           tint = Color.Black
                       )
                   } ,
                   modifier = Modifier ,
                   visualTransformation = showPassword.value
               )

            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(
                    text = "forget password!",
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .clickable(enabled = true) { },
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(60.dp))
                Text(
                    text = "Show password" ,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .clickable(enabled = true) {
                             onclick
                        },
                    color = Color.Black
                )
           }
          Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = { /*TODO*/ } ,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF2551CC) ,
                contentColor = Color.White
            ) ,
            modifier = Modifier
                .width(200.dp)
                .height(50.dp),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "login" ,
                fontSize = 20.sp
            )
        }
    }
}
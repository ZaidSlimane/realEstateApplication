package com.example.realestat

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.realestateapplication.Presentation.States.ScreenRoute
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun OnbordingScreen(navController: NavController) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(Color(0xFF001F3F) )
    }
    val onboardPages = onboardPagesList
    val currentPage = remember {
        mutableStateOf(0)
    }
    Column (
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        ) {
            Spacer(modifier = Modifier.width(300.dp))
            Button(
                onClick = {
                          navController.navigate(ScreenRoute.LoginSreen.route)
                } ,
                modifier = Modifier
                    .padding(top = 60.dp) ,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFDFDFDF)
                )
            ) {
                Text(text = "Skip")
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        content(
            description = onboardPages[currentPage.value].description,
            keyWord = onboardPages[currentPage.value].keyWord,
            Image = onboardPages[currentPage.value].imageRes
        )
        Row(
            modifier= Modifier
                .fillMaxWidth()
                .padding(30.dp)
        ) {
            OnBoardNavButtonToBack() {
                when{
                    currentPage.value>0 && currentPage.value<=2 -> currentPage.value--
                    else-> navController.navigate(ScreenRoute.SplashScreen.route)
                }
            }
            Spacer(modifier = Modifier.width(70.dp))
            OnBoardNavButtonToNext() {
                when{
                    currentPage.value>=0 && currentPage.value<2 -> currentPage.value++
                    else-> navController.navigate(ScreenRoute.LoginSreen.route)
                }
            }
        }
    }
}

@Composable
fun content(
    description : String ,
    keyWord : String ,
    Image : Int
) {
    Text(
        text = description ,
        color = Color.Black ,
        fontSize = 25.sp ,
        modifier = Modifier.padding(start = 35.dp)
    )
    Text(
        text = keyWord ,
        color = Color(0xFF204D6C),
        fontSize = 25.sp ,
        modifier = Modifier.padding(start = 35.dp)
    )
    val x = LocalConfiguration.current.screenWidthDp
    val y = LocalConfiguration.current.screenHeightDp
    val sqe = ( (x * y) / 610).dp
    Image(
        painter = painterResource(id = Image),
        contentDescription = "" ,
        modifier = Modifier
            .size(sqe)
            .padding(top = 50.dp)
    )
}


@Composable
fun OnBoardNavButtonToNext(
     onNextClicked: () -> Unit
) {
    Button(
        onClick = {
                onNextClicked()
        } ,
        shape = RoundedCornerShape(10.dp) ,
        modifier = Modifier
            .width(180.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF001F3F)
        )
    ) {
        Text(text = "Next" ,  color = Color.White)
    }
}

@Composable
fun OnBoardNavButtonToBack(
    onNextClicked: () -> Unit
) {
    IconButton(
        onClick = {
                onNextClicked()
        },
        modifier = Modifier
            .clip(CircleShape),
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = Color.White
        )
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription ="" ,
            tint = Color.Black
            )
    }
}
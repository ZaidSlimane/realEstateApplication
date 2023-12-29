package com.example.realestateapplication.Presentation.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realestateapplication.R

@Composable
fun PropertyDetailsScreen (){
    Box(modifier = Modifier.fillMaxSize()){

        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)){

            Image(painter = painterResource(id = R.drawable.img_1) ,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.FillHeight)

            CircularFilleddBox(icon = R.drawable.search)

            Drawer()
        }

        Box(
            modifier = Modifier
                .padding(top = 300.dp)
                .fillMaxWidth()
                .clip(
                    RoundedCornerShape(8.dp)
                )
        ) {

            Card( modifier = Modifier
                .fillMaxSize(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White),
            )
            {


                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(SweepGradientExample()) ){


                    GradientCircularShape()



                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(start = 16.dp)) {

                        Row(horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .offset(x = (20).dp)
                                .fillMaxWidth()
                                .padding(
                                    top = 16.dp
                                ))
                        {


                            Text(text = "Villa Vice City",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                modifier = Modifier
                                    .padding()
                                    .offset(-20.dp)
                            )



                            Card(modifier = Modifier
                                .border(
                                    BorderStroke(1.dp, Color.Black),
                                    shape = RoundedCornerShape(50.dp)
                                )
                                .width(120.dp)
                                .height(50.dp),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color.White),
                                shape = RoundedCornerShape(50.dp),
                                elevation = CardDefaults.cardElevation(
                                    defaultElevation = 5.dp,
                                    focusedElevation = 2.dp
                                )

                            ){
                                Column(
                                    modifier = Modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(text = "26700$")
                                }
                            }
                        }



                        Divider(color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(top = 16.dp,
                                    end = 16.dp))

                        PropertySpecs()

                        Divider(color = Color.Gray,
                            thickness = 1.dp,
                            modifier = Modifier
                                .padding(
                                    end = 16.dp))

                        Column(Modifier.padding(top = 16.dp)) {
                            Text("Description",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontWeight = FontWeight.Bold,
                                ),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 8.dp)
                            )

                            Text("Located in the heart of Anytown, this home boasts a spacious living room with large windows that let in plenty of natural light.")

                            Box(modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(bottom = 16.dp)

                            ){
                                Button(onClick = { /*TODO*/ },
                                    colors = ButtonDefaults.buttonColors(Color(0xFF001F3F)),
                                    modifier = Modifier
                                        .align(Alignment.BottomCenter)
                                        .width(166.dp)
                                        .height(63.dp)
                                        .background(
                                            color = Color(0xFF001F3F),
                                            shape = RoundedCornerShape(size = 10.dp),
                                        )
                                ) {
                                    Text(text = "Buy")
                                }
                            }

                        }

                    }




                }


            }


        }
    }
}



@Composable
fun PropertySpecs(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 16.dp)
            .clip(RoundedCornerShape(50.dp))
            .padding(
                vertical = 16.dp,
                horizontal = 16.dp
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        CircularOutlinedBox(icon = R.drawable.search)
        CircularOutlinedBox(icon = R.drawable.search)
        CircularOutlinedBox(icon = R.drawable.search)
        CircularOutlinedBox(icon = R.drawable.search)




    }
}


@Composable
fun CircularOutlinedBox(icon : Int){

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedButton(onClick = { },
            modifier= Modifier.size(50.dp),  //avoid the oval shape
            shape = CircleShape,
            contentPadding = PaddingValues(0.dp),  //avoid the little icon

        )
        {
            Image(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
        }

        Text(text = "100",
            style = TextStyle(
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
            ),
            modifier = Modifier.padding(top = 8.dp)
        )

    }

}

@Composable
fun CircularFilleddBox(icon : Int){


   Column(Modifier.padding(horizontal = 8.dp,
       vertical = 8.dp)) {
       FilledIconButton(onClick = { /*TODO*/ },
           modifier= Modifier
               .size(50.dp)
               .clip(CircleShape),
           colors = IconButtonDefaults.filledIconButtonColors(
               containerColor = Color.White,
           )
       ) {

           Image(
               painter = painterResource(id = icon),
               contentDescription = null,
               modifier = Modifier
                   .size(24.dp)
           )



       }
   }
    


}

@SuppressLint("InvalidColorHexValue")
@Composable
fun SweepGradientExample() : Brush {
    val colorStops = listOf(
        0.02f to Color(0x20B9DAFB),
        0.14f to Color(0x20ECACAD),
        0.31f to Color(0x309895EE),
        0.54f to Color(0x404490A2F8),
        0.81f to Color(0xFFC55492),
    ).toTypedArray()

    val density = LocalDensity.current
    val centerX: Float
    val centerY: Float
    with(density) {
        centerX =-300.dp.toPx() /2
        centerY = 0.dp.toPx() / 2
    }
    val brush = Brush.sweepGradient(
        colorStops = colorStops,
        center = Offset(centerX, centerY)
    )
    return brush
}

@Composable
fun GradientCircularShape() {


    val density = LocalDensity.current
    val centerX: Float
    val centerY: Float
    with(density) {
        centerX =300.dp.toPx() /2
        centerY = 0.dp.toPx() / 2
    }

    val brush = Brush.sweepGradient(
        colors = listOf(
            Color(0x10F4AF4),
            Color(0x209895EE)
        ),
        center = Offset(centerX, centerY)
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize()
            .size(30.dp)
            .background(brush)
    ) {
    }
}

@Composable
fun GradientCircularShape2() : Brush {


    val density = LocalDensity.current
    val centerX: Float
    val centerY: Float
    with(density) {
        centerX =300.dp.toPx() /2
        centerY = 0.dp.toPx() / 2
    }

    val brush = Brush.sweepGradient(
        colors = listOf(
            Color(0x10F4AF4),
            Color(0x209895EE)
        ),
        center = Offset(centerX, centerY)
    )
return brush
}

@Composable
fun Drawer() {
    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 180.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)


        ) {
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CardWithImage(image = R.drawable.img_1,0.dp,0.dp)
                CardWithImage(image = R.drawable.img_1,0.dp,0.dp)
                CardWithImage(image = R.drawable.img_1,3.dp,3.dp)
            }

        }
    }
}

@Composable
fun CardWithImage(image : Int, radiusX: Dp, RadiusY : Dp) {
    Card(
        modifier = Modifier

            .padding(
                top = 8.dp,
                bottom = 8.dp
            )
            .size(100.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                contentScale = ContentScale.FillHeight,
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .blur(
                        radiusX = radiusX,
                        radiusY = RadiusY,
                    )
            )
        }
    }
}




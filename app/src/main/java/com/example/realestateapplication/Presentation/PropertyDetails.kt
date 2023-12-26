package com.example.realestateapplication.Presentation

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
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
                    containerColor = Color.White)
                ){


                Row(horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .offset(x = (20).dp)
                        .fillMaxWidth()
                        .padding(
                            start = 16.dp,
                            top = 16.dp
                        ))
                {


                    Text(text = "Villa Vice City",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        ),
                        modifier = Modifier.padding()
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
                        .padding(top = 24.dp,
                            end = 16.dp,
                            start = 16.dp),)

                PropertySpecs()

                Divider(color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier
                        .padding(
                            end = 16.dp,
                            start = 16.dp),)

                Column {
                    Text("Description",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )


                    Text("Located in the heart of Anytown, this home boasts a spacious living room with large windows that let in plenty of natural light.")
                }






            }

        }    }
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
        horizontalArrangement = Arrangement.SpaceEvenly
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

package com.example.realestateapplication.Presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import com.example.realestateapplication.Model.Proprety
import com.example.realestateapplication.R


val proprety1 = Proprety(R.drawable.img, 2000, 4,1)
val proprety2 = Proprety(R.drawable.img, 2000, 4,1)
val proprety3 = Proprety(R.drawable.img, 2000, 4,1)
val proprety4 = Proprety(R.drawable.img, 2000, 4,1)

val stringList: ArrayList<String> = arrayListOf("String1", "String2", "String3", "String4", "String5")
val propretyDataSample: ArrayList<Proprety> = arrayListOf(proprety1, proprety2, proprety3, proprety4)

@Preview
@Composable
fun homeScreen(userName: String, onClick: () -> Unit ) {


    Column (modifier = Modifier.fillMaxSize()
        .background(
            brush = Brush.radialGradient(
                colors = listOf(Color.White, Color.LightGray),
                center = Offset(x = 2f, y = 2f) // center
            )
        )
    ){

        Column(  modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
        )

        {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        vertical = 12.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Hello! ",
                        style = TextStyle(fontSize = 12.sp)
                    )
                    Text(
                        text = userName,
                        style = TextStyle(fontSize = 24.sp)
                    )

                }
                ProfileIcon(onClick)

            }

            searchBar()

        }
        filterLazyRow(buildingTypeList = stringList )
        CarRow(data = propretyDataSample)
       CardColumn(data = propretyDataSample)


    }

}


@Composable
fun ProfileIcon(onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .size(60.dp)
            .background(MaterialTheme.colorScheme.primary)
            .clip(CircleShape)
            .clickable { onClick() }
            .padding(8.dp),
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Clickable Icon",
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            tint = Color.White
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchBar() {

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            OutlinedTextField(value = "", onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.5f)
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp
                    )
                    .shadow(5.dp, RoundedCornerShape(30.dp))
                    .background(Color(0XF2F3F5), shape = RoundedCornerShape(size = 12.dp)),
                placeholder = {
                    Text(
                        text = "Search here",
                        modifier = Modifier.alpha(12f),
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    cursorColor = Color.Black,
                    textColor = Color.Black,
                    focusedIndicatorColor = colorResource(id = R.color.teal_200),
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(30.dp),
                leadingIcon = {
                    IconButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.alpha(12f)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = "Search icon",
                            tint = Color(0xFF5AA2B8)
                        )
                    }
                }

            )




                    Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.5f)
                    .padding(start = 16.dp)
                    .padding(
                        top = 8.dp,
                        bottom = 8.dp
                    )
                    .background(
                        Color(R.color.darkBlue),
                        shape = RoundedCornerShape(12.dp)
                    ),



                        shape = RoundedCornerShape(50),
                colors = ButtonDefaults.run { buttonColors(Color.Transparent) }
            ) {
            }
        }
}

@Composable
fun filterLazyRow (buildingTypeList : ArrayList<String>){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        items(buildingTypeList.size) { index ->
            SearchByTypeButtons(index = index)
        }
    }
}

@Composable
fun SearchByTypeButtons(index: Int) {
    Button(
        onClick = { /* Handle button click */ },
        modifier = Modifier
            .padding(
              top = 21.dp,
                start = 24.dp,
                end = 10.dp
            ) )
            {
        Text(

            text = "Apartement $index",
            modifier = Modifier
            .padding(
            horizontal = 24.dp,
            vertical = 17.5.dp
        ),
        )
    }
}

@Composable
fun CarRow(data : ArrayList<Proprety>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(data.size) { index ->
            CardItem(property = data[index])
        }
    }
}

@Composable
fun CardColumn(data : ArrayList<Proprety>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentPadding = PaddingValues(horizontal = 8.dp)
    ) {
        items(data.size) { index ->
            FeaturedPropretyCardItem(property = data[index])
        }
    }
}


@Composable
fun CardItem(property: Proprety) {
    Card(
        modifier = Modifier
            .size(220.dp, 300.dp)
            .background(Color.White)
            .padding(8.dp),
        shape = RoundedCornerShape(30.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 3.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White)
    ) {
        Box(Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(property.propretyIamge),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.8f) // Adjust the height as needed
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(text = "Apartment",
                        style = TextStyle(fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                            )
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(text = "2600$",
                        style = TextStyle(fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    SmallImageWithText(R.drawable.search, property.suraface)
                    Spacer(modifier = Modifier.width(8.dp))
                    SmallImageWithText(R.drawable.search, property.places)
                    Spacer(modifier = Modifier.width(8.dp))
                    SmallImageWithText(R.drawable.search, property.kitchens)
                }
            }
        }
    }
}

@Composable
fun FeaturedPropretyCardItem (property: Proprety) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(30.dp)
    )
        {
        Box(Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
               horizontalArrangement = Arrangement.Start

            ) {
                Image(
                    painter = painterResource(property.propretyIamge),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.2f) // Adjust the height as needed
                )

                Spacer(modifier = Modifier.height(8.dp))

                Column {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(text = "Apartment",
                            style = TextStyle(fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.width(8.dp))

                        Text(text = "2600$",
                            style = TextStyle(fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))




                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        SmallImageWithText(R.drawable.search, property.suraface)
                        Spacer(modifier = Modifier.width(8.dp))
                        SmallImageWithText(R.drawable.search, property.places)
                        Spacer(modifier = Modifier.width(8.dp))
                        SmallImageWithText(R.drawable.search, property.kitchens)
                    }

                }



            }
        }
    }
}


@Composable
fun SmallImageWithText(imageResId: Int, text: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text.toString(),
            style = TextStyle(fontSize = 12.sp,
            )
        )
    }
}






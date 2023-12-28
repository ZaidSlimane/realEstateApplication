package com.example.realestateapplication.Presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realestateapplication.Model.Proprety
import com.example.realestateapplication.Model.Transaction
import com.example.realestateapplication.Presentation.Components.CustomProgressBar
import com.example.realestateapplication.R

val transaction1 = Transaction(R.drawable.search, "date", "4", "1")
val transaction2 = Transaction(R.drawable.search, "date", "4", "1")
val transaction3 = Transaction(R.drawable.search, "date", "4", "1")
val transaction4 = Transaction(R.drawable.search, "date", "4", "1")

val transactionDataSample: ArrayList<Transaction> = arrayListOf(transaction1, transaction2, transaction3, transaction4)
@Composable
fun PaymentTransactionScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(SweepGradientExample())
    ) {

        Card(
            modifier = Modifier
                .padding(horizontal = 15.dp)
                .padding(top = 50.dp)
                .fillMaxWidth()
                .height(150.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp,
            )
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
            ) {

                Text(
                    "Remaining",
                    style = TextStyle(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                    ),
                    modifier = Modifier
                        .padding(top = 8.dp)
                )

                Text(
                    "10000 $",
                    style = TextStyle(
                        fontSize = 24.sp,
                    ),
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
                CustomProgressBar()
            }

        }

        // Row with two buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(Color(0xFF001F3F)),
                onClick = {
                    // Handle the first button click
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text("History")
            }

            Button(
                colors = ButtonDefaults.buttonColors(Color(0xFF001F3F)),
                onClick = {
                    // Handle the second button click
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                Text("Rest to pay")
            }
        }

        Card(
            modifier = Modifier
                .align(Alignment.Start)
                .padding(top = 16.dp)
                .fillMaxHeight(1.0f)
                .fillMaxWidth()
                .height(150.dp)
                .background(GradientCircularShape2()),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp,
            )
        ) {
            TrasactionsList(transactionDataSample)
        }
    }
}



@Composable
private fun TrasactionsList(transaction : ArrayList<Transaction>){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            items(transaction.size) { index ->
                TransactionItem(transaction[index])
            }
        }
    }


@Composable
private fun TransactionItem(transaction: Transaction) {

    Column (
        Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 16.dp,
                vertical = 32.dp
            ),
        ){

        Row(
            modifier = Modifier
                .fillMaxWidth()
            ,
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = transaction.icon),
                contentDescription = null, // contentDescription can be added based on your needs
            )
            Text(
                text = transaction.date,
            )
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = transaction.price,
                    textAlign = TextAlign.End
                )

                Text(text = " Success")
            }
        }
        Divider(color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier
                .padding(
                    top = 1.2.dp))
    }

}


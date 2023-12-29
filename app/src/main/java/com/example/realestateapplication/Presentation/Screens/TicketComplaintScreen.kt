package com.example.realestateapplication.Presentation.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dawinder.customshapes_jc.ui.shapes.TicketShape
import com.example.realestateapplication.Presentation.Components.OutlinedTextFieldComp
import com.example.realestateapplication.Presentation.Components.textedButton
import com.example.realestateapplication.R


@Composable
fun TicketComplaintScreen(){


        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
                .background(SweepGradientExample())
        ) {
            CircularFilleddBox(icon = R.drawable.search)


            Box(modifier = Modifier.
            align(Alignment.CenterHorizontally)
            ){

                ProfileIcon {
                }
            }

            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .shadow(
                        2.dp, // change the shadow as needed
                        shape = TicketShape(15f, 8f), // here
                        clip = true
                    )
                    .background(Color.White)
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
            ) {
                ComplaintForm()
            }

            textedButton(buttonText = "Sumbit",
                alignment = Alignment.BottomCenter,
                paddingValues = PaddingValues(bottom = 16.dp))

        }
    }



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComplaintForm() {

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        OutlinedTextFieldComp(
            type = "Subject",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextFieldComp(
            type = "Type",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextFieldComp(
            type = "Floor",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        OutlinedTextFieldComp(
            type = "Description",
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .fillMaxHeight()
        )
        }
    }


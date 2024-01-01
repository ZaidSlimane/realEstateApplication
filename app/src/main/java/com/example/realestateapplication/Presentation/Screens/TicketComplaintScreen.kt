package com.example.realestateapplication.Presentation.Screens

import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dawinder.customshapes_jc.ui.shapes.TicketShape
import com.example.realestateapplication.Presentation.Components.OutlinedTextFieldComp
import com.example.realestateapplication.Presentation.Components.textedButton
import com.example.realestateapplication.R
import com.example.realestateapplication.ViewModels.ComplaintTicketViewModel



@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun TicketComplaintScreen(
    ticketViewModel: ComplaintTicketViewModel = hiltViewModel()
){

    var _type by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var floor by remember { mutableStateOf("") }


    val context = LocalContext.current

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

                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxSize()
                ) {

                   subject =  OutlinedTextFieldComp(
                        type = "Subject",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )

                   _type = OutlinedTextFieldComp(
                        type = "Type",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )

                   floor = OutlinedTextFieldComp(

                        type = "Floor",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )

                    description = OutlinedTextFieldComp(
                        type = "Description",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .fillMaxHeight()
                    )



                }
            }

        var fields = remember {
            mapOf(
                "type" to _type,
                "subject" to subject,
                "description" to description,
                "floor" to floor
            )
        }

        Log.d("Button", fields.toString() )

            textedButton(
                fields,
                ticketViewModel,
                buttonText = "Sumbit",
                alignment = Alignment.BottomCenter,
                paddingValues = PaddingValues(bottom = 16.dp))
        }
    }




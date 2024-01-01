package com.example.realestateapplication.Presentation.Screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dawinder.customshapes_jc.ui.shapes.TicketShape
import com.example.realestateapplication.Model.ComplaintTicket
import com.example.realestateapplication.Presentation.Components.textedButton
import com.example.realestateapplication.R
import com.example.realestateapplication.ViewModels.ComplaintTicketViewModel




@SuppressLint("SuspiciousIndentation", "StateFlowValueCalledInComposition")
@OptIn(ExperimentalMaterial3Api::class)

@Composable
fun TicketComplaintScreen(
    ticketViewModel: ComplaintTicketViewModel = hiltViewModel()
){
    /**
     * STATE ATRIBUTE OBSERVER
     */
    val thisScreenState by ticketViewModel.ticketState.collectAsState()

    var _type by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var floor by remember { mutableStateOf("") }

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

                    if(!thisScreenState.isDataAdded){
                        OutlinedTextField(
                            value = subject,
                            onValueChange = { subject = it },
                            label = { Text("Subject") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Done
                            )
                        )

                        OutlinedTextField(
                            value = _type,
                            onValueChange = { _type = it },
                            label = { Text("Type") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Done
                            )
                        )

                        OutlinedTextField(
                            value = floor,
                            onValueChange = { floor = it },
                            label = { Text("Floor") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Done
                            )
                        )

                        OutlinedTextField(
                            value = description,
                            onValueChange = { description = it },
                            label = { Text("Description") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight()
                                .padding(8.dp),
                            keyboardOptions = KeyboardOptions.Default.copy(
                                imeAction = ImeAction.Done
                            )
                        )

                    }else{
                        TODO("MAKE AN ANIMATION WHEN FINISHED ADDING DATA")
                    }



                }
            }


 val fields = ComplaintTicket(description,floor,subject, _type)
            textedButton(
                thisScreenState,
                fields,
                ticketViewModel,
                buttonText = "Sumbit",
                alignment = Alignment.BottomCenter,
                paddingValues = PaddingValues(bottom = 16.dp))
        }
    }




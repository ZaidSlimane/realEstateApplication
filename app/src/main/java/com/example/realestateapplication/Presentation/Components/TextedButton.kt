package com.example.realestateapplication.Presentation.Components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.realestateapplication.Model.ComplaintTicket
import com.example.realestateapplication.Presentation.States.ComplaintTicketState
import com.example.realestateapplication.ViewModels.ComplaintTicketViewModel


@Composable()
fun textedButton(
    thisScreenState: ComplaintTicketState,
    fields: ComplaintTicket,
    ticketViewModel: ComplaintTicketViewModel,
    buttonText: String,
    alignment: Alignment,
    paddingValues: PaddingValues
){

    val context = LocalContext.current

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(paddingValues)

    ){
        Button(onClick= {
            try {
                ticketViewModel.values = fields
                ticketViewModel.writeNewComplaint()
                Toast.makeText(context,"try",Toast.LENGTH_LONG).show()
                Log.d("Button", fields.toString())

            }catch (e:Exception){
                Log.d("Button", e.stackTraceToString())
            }

        },
            colors = ButtonDefaults.buttonColors(Color(0xFF001F3F)),
            modifier = Modifier
                .align(alignment)
                .width(166.dp)
                .height(63.dp)
                .background(
                    color = Color(0xFF001F3F),
                    shape = RoundedCornerShape(size = 10.dp),
                )
        ) {
            Text(text = buttonText)
        }
    }

}
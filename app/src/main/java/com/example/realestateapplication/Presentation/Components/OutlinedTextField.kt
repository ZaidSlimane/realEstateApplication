package com.example.realestateapplication.Presentation.Components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import com.example.realestateapplication.ViewModels.ComplaintTicketViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldComp (
    type: String,
    modifier: Modifier) : String
{
    var valueTest by remember { mutableStateOf("") }

    OutlinedTextField(
        value = valueTest,
        onValueChange = { valueTest = it },
        label = { Text(type) },
        modifier = modifier,
        keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
                )
    )
    return  valueTest.toString()
    Log.d("Button", valueTest.toString())




}
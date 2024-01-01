/*package com.example.realestateapplication.Presentation.Components

import android.util.Log
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldComp (
    textFieldValue: TextFieldValue,
    type: String,
    modifier: Modifier
) : String
{


    OutlinedTextField(
        value = textFieldValue,
        onValueChange = { textFieldValue = it },
        label = { Text(type) },
        modifier = modifier,
        keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
                )
    )
    return  valueTest.toString()
    Log.d("Button", valueTest.toString())




}

 */
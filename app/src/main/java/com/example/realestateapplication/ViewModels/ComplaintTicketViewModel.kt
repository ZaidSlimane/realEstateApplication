package com.example.realestateapplication.ViewModels

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realestateapplication.Model.ComplaintTicket
import com.example.realestateapplication.Repositories.FirebaseRepo
import com.google.android.filament.Filament.init
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ComplaintTicketViewModel @Inject constructor(
    private val firebaseRepo: FirebaseRepo
) : ViewModel() {

    //private val _TicketState = MutableStateFlow(ComplaintTicket())
    //val ticketState: StateFlow<ComplaintTicket> = _TicketState.asStateFlow()

    var id : String = "0"
    private var _values: Map<String, String> = emptyMap()

    var values: Map<String, String>
        get() = _values
        set(value) {
            _values = value
        }
    private fun checkInputFields() : Boolean {
        return values["type"].isNullOrEmpty() ||
                values["floor"].isNullOrEmpty() ||
                values["description"].isNullOrEmpty() ||
                values["subject"].isNullOrEmpty()
    }

        fun writeNewComplaint() {
            viewModelScope.launch(Dispatchers.IO) {
                if (!checkInputFields()) {
                    firebaseRepo.writeNewComplaint(id, values)
                    id = (id.toInt() + 1).toString()
                    Log.d("values",values["floor"].toString())
                }
                else{
                    Log.d("values","empty")

                }
            }
            }
    }


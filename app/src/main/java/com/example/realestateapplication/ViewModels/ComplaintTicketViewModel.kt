package com.example.realestateapplication.ViewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.realestateapplication.Model.ComplaintTicket
import com.example.realestateapplication.Presentation.States.ComplaintTicketState
import com.example.realestateapplication.Repositories.FirebaseRepo
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

    private val _TicketState = MutableStateFlow(ComplaintTicketState())
    val ticketState: StateFlow<ComplaintTicketState> = _TicketState.asStateFlow()

    var id : String = "0"
    private lateinit var _values: ComplaintTicket

    var values: ComplaintTicket
        get() = _values
        set(value) {
            _values = value
        }
    private fun checkInputFields() : Boolean {
        return values.type.isNullOrEmpty() ||
                values.subject.isNullOrEmpty() ||
                values.description.isNullOrEmpty() ||
                values.floor.isNullOrEmpty()
    }

        fun writeNewComplaint() {
            viewModelScope.launch(Dispatchers.IO) {
                if (!checkInputFields()) {
                    firebaseRepo.writeNewComplaint(id, values)
                    _TicketState.value.isDataAdded = true
                    id = (id.toInt() + 1).toString()
                }
                else{
                    Log.d("values","empty")

                }
            }
            }
    }


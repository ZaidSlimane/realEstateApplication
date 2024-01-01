package com.example.realestateapplication.Repositories

import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.realestateapplication.Model.ComplaintTicket
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import javax.inject.Inject

class FirebaseRepo @Inject constructor(
    val  databaseReference: DatabaseReference
){

   suspend fun writeNewComplaint(id: String, fields: Map<String, String>){

        val description = fields["description"]
        val type = fields["type"]
        val floor = fields["floor"]
        val subject = fields["subject"]

        val newComplaintTicket = ComplaintTicket(
            description,
            floor,
            subject,
            type
        )
       databaseReference.child(id).setValue(newComplaintTicket)
           .addOnSuccessListener {
               // Data added successfully
               // You can add any additional logic here
               Log.d("writedatadone","log")
           }
           .addOnFailureListener { e ->
               // Handle the error
               // e.g., Log.d("Firebase", "Error adding data: ${e.message}")
               Log.d("writedatacancelled","log")
           }
   }

}
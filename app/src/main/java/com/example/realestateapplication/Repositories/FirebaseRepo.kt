package com.example.realestateapplication.Repositories

import android.util.Log
import com.example.realestateapplication.Model.ComplaintTicket
import com.google.firebase.database.DatabaseReference
import javax.inject.Inject

class FirebaseRepo @Inject constructor(
    val  databaseReference: DatabaseReference
){

   suspend fun writeNewComplaint(id: String, newComplaintTicket: ComplaintTicket){
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
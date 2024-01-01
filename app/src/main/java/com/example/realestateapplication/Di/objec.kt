package com.example.realestateapplication.Di

import com.example.realestateapplication.Repositories.FirebaseRepo
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  HiltModule{
    @Provides
    @Singleton

    fun provideYourRepository(): FirebaseRepo = FirebaseRepo(providesDatabaseReference())


    @Provides
    @Singleton
    fun providesDatabaseReference():DatabaseReference =
        Firebase.database.reference.child("Complaints")
}
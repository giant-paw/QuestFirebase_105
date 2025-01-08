package com.example.a08januari2025.di

import com.example.a08januari2025.repository.MahasiswaRepository
import com.example.a08januari2025.repository.NetworkMahasiswaRepository
import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer {
    val mahasiswaRepository: MahasiswaRepository
}

class MahasiswaContainer: AppContainer{
    private val firebase: FirebaseFirestore = FirebaseFirestore.getInstance()      // Sama dengan Base URL

    override val mahasiswaRepository: MahasiswaRepository by lazy {
        NetworkMahasiswaRepository(firebase)
    }
}
package com.example.a08januari2025

import android.app.Application
import com.example.a08januari2025.di.AppContainer
import com.example.a08januari2025.di.MahasiswaContainer

class MahasiswaApplications: Application() {
    lateinit var container: AppContainer
    override fun onCreate(){
        super.onCreate()
        container = MahasiswaContainer()
    }
}
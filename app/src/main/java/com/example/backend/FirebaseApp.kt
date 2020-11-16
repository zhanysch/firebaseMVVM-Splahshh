package com.example.backend

import android.app.Application
import com.example.backend.architect.di.apiModule
import com.example.backend.architect.di.repositoryModule
import com.example.backend.architect.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FirebaseApp: Application() {  // этот класс чисто для поддержки коин МVVM

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@FirebaseApp)
            modules(listOf(apiModule,repositoryModule,viewModelModule))
        }
    }
}
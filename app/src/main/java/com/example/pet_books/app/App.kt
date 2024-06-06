package com.example.pet_books.app

import android.app.Application
import com.example.pet_books.di.dataModule
import com.example.pet_books.di.interactorModule
import com.example.pet_books.di.repositoryModule
import com.example.pet_books.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(androidContext = this@App)
            modules(dataModule, interactorModule, repositoryModule, viewModelModule)

        }
    }

}
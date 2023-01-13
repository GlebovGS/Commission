package com.example.myapplication.presentation.dependency_injection

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class StartCoin:Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@StartCoin)
            modules(listOf(dataModule, domainModule, presentationModule))
        }
    }

}
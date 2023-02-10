package com.example.youtubeapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.youtubeapp.data.db.AppDatabase
import com.example.youtubeapp.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@App)
            modules(koinModules)
        }
    }
}

package com.example.youtubeapp

import android.app.Application
import androidx.room.Room
import com.example.youtubeapp.data.db.AppDatabase

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()
    }

    companion object{
        lateinit var db: AppDatabase
    }
}
package com.example.roomdatabaseintroduction.Model

import android.app.Application
import androidx.room.Room
import androidx.room.Room.databaseBuilder


class ConnectDb:Application() {

    companion object{
        lateinit var database: Database
    }

    val db = Room.databaseBuilder(
        applicationContext,
        Database::class.java,
        "WorkerDatabase"
    ).build()
}
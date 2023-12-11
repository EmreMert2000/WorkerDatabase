package com.example.roomdatabaseintroduction.Model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [WorkerData::class], version = 2)
abstract class AppDatabase : RoomDatabase() {

    abstract fun DaoInterface(): DaoInterface

    companion object {
        private var instance: AppDatabase? = null

        fun getAllWorkers(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context):AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "WorkerData"
            ).allowMainThreadQueries().build()
        }
    }
}
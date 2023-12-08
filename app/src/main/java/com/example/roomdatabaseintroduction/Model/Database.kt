package com.example.roomdatabaseintroduction.Model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities =  [WorkerData::class], version = 2)
 abstract class Database:RoomDatabase() {
     abstract fun workerdao():DaoInterface


}
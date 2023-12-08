package com.example.roomdatabaseintroduction.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Workers")
 class WorkerData(
    @PrimaryKey(autoGenerate = true)
     val id:Int=0,
    @ColumnInfo(name = "name")
     val name:String,
    @ColumnInfo(name = "age")
     val age:Int=0,
    @ColumnInfo(name = "ke")
     val ke:String,
    @ColumnInfo(name = "cost")
     val cost:Int=0
 )


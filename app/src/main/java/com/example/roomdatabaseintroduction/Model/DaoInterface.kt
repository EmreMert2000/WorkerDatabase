package com.example.roomdatabaseintroduction.Model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DaoInterface {
    @Query("SELECT * from Workers")
    fun getAllWorkers():List<WorkerData>

    @Insert
    fun insert(workerData: WorkerData)




}
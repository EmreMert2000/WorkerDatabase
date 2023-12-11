package com.example.roomdatabaseintroduction.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Database
import com.example.roomdatabaseintroduction.Model.AppDatabase
import com.example.roomdatabaseintroduction.R
import com.example.roomdatabaseintroduction.databinding.ActivityDataBinding
import com.example.roomdatabaseintroduction.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class DataActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
          GlobalScope.launch(Dispatchers.IO){
               val workers=AppDatabase.getAllWorkers(this@DataActivity).DaoInterface().getAllWorkers()
              launch (Dispatchers.Main){
                 val stringBuilder=StringBuilder()
                  for(worker in workers){
                      stringBuilder.append("${worker.name}, ${worker.age} ${worker.ke}, ${worker.cost}")
                  }
                  stringBuilder.append("\n")
                    binding.dataTextView.text=stringBuilder.toString()
              }
          }
    }
}
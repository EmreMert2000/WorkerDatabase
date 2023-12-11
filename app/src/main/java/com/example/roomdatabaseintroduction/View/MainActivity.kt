package com.example.roomdatabaseintroduction.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roomdatabaseintroduction.Model.AppDatabase
import com.example.roomdatabaseintroduction.Model.WorkerData
import com.example.roomdatabaseintroduction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.button.setOnClickListener{
                val name=binding.AddNameText.text.toString()
                val age=binding.AddAgeText.text.toString().toIntOrNull() ?: 0
                val ke=binding.AddKEText.text.toString()
                val cost=binding.AddCostText.text.toString().toIntOrNull() ?: 0
                val worker=WorkerData(name =name,age=age,ke=ke,cost=cost)
                AppDatabase.getAllWorkers(this).DaoInterface().insert(worker)
            startActivity(Intent(this, DataActivity::class.java))

        }

    }
}
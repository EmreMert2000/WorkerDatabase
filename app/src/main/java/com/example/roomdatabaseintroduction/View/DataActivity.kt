package com.example.roomdatabaseintroduction.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TableRow
import android.widget.TextView
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
         GlobalScope.launch (Dispatchers.IO){
             val workers=AppDatabase.getAllWorkers(this@DataActivity).DaoInterface().getAllWorkers()

            launch(Dispatchers.Main) {
                val tableLayout=binding.tableLayout
                for (worker in workers) {
                    Log.d("DataActivity", "Worker: ${worker.name}, Age: ${worker.age}, K/E: ${worker.ke}, Cost: ${worker.cost}")

                    val tableRow = TableRow(this@DataActivity)

                    // İsim TextView
                    val nameTextView = TextView(this@DataActivity)
                    nameTextView.text = worker.name
                    nameTextView.width = 100 // Uygun bir genişlik belirleyin
                    tableRow.addView(nameTextView)

                    // Yaş TextView
                    val ageTextView = TextView(this@DataActivity)
                    ageTextView.text = worker.age.toString()
                    ageTextView.width = 100 // Uygun bir genişlik belirleyin
                    tableRow.addView(ageTextView)

                    // K/E TextView
                    val keTextView = TextView(this@DataActivity)
                    keTextView.text = worker.ke
                    keTextView.width = 100 // Uygun bir genişlik belirleyin
                    tableRow.addView(keTextView)

                    // Cost TextView
                    val costTextView = TextView(this@DataActivity)
                    costTextView.text = worker.cost.toString()
                    costTextView.width = 100 // Uygun bir genişlik belirleyin
                    tableRow.addView(costTextView)

                    // TableRow'ı TableLayout'a ekle
                    tableLayout.addView(tableRow)
                }

    }

            }
         }

}
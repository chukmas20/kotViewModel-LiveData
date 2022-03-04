package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
//    var count = 0
    // reference variable for viewModel Object
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        val inputText = findViewById<TextView>(R.id.tvShow)
        val button = findViewById<Button>(R.id.btnCount)

//        inputText.text = count.toString()
//        inputText.text = viewModel.count.toString()
        viewModel.count.observe(this, Observer{
            inputText.text = it.toString()
        })

        button.setOnClickListener {
//            ++count
//            inputText.text = count.toString()
            viewModel.updateCount()
//            inputText.text = viewModel.count.toString()
        }

    }
}
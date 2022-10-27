package com.example.LabW2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class ResultActivity:AppCompatActivity(){
    private lateinit var textResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_layout)
        textResult = findViewById(R.id.resultNumber)
        textResult.setText(intent.getStringExtra("відповідь").toString())
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}

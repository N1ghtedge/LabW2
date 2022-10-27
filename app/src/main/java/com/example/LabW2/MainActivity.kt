package com.example.LabW2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    private lateinit var number1 : EditText
    private lateinit var number2 : EditText
    private lateinit var plusBtn : Button
    private lateinit var minusBtn : Button
    private lateinit var mnBtn : Button
    private lateinit var dlBtn : Button
    private lateinit var clearBtn : Button
    private lateinit var resultNumber : TextView
    private lateinit var showResult : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initActivity()
    }

    private fun initActivity(){
        number1 = findViewById(R.id.n1)
        number2 = findViewById(R.id.n2)
        plusBtn = findViewById(R.id.plus)
        minusBtn = findViewById(R.id.minus)
        mnBtn = findViewById(R.id.mn)
        dlBtn = findViewById(R.id.dl)
        clearBtn = findViewById(R.id.clear)
        showResult = findViewById(R.id.result)

        val intent = Intent(this, ResultActivity::class.java)
        result(intent)
        plus(intent)
        minus(intent)
        mnozh(intent)
        dil(intent)
        clear(intent)
    }

    private fun plus(intent: Intent){
        plusBtn.setOnClickListener{
            if(number1.text.isEmpty() || number2.text.isEmpty()){
                intent.putExtra("відповідь", "Немає відповіді") }
            else
            {
                val inputNumber = number1.text.toString().toFloat()+ number2.text.toString().toFloat()
                intent.putExtra("відповідь", inputNumber.toString())
            }
        }
    }

    private fun minus(intent: Intent){
        minusBtn.setOnClickListener{
            if(number1.text.isEmpty() || number2.text.isEmpty()){
                intent.putExtra("відповідь", "Немає відповіді") }
            else {
                val inputNumber = number1.text.toString().toFloat() - number2.text.toString().toFloat()
                intent.putExtra("відповідь", inputNumber.toString())
            }
        }
    }

    private fun mnozh(intent: Intent){
        mnBtn.setOnClickListener{
            if(number1.text.isEmpty() || number2.text.isEmpty()){
                intent.putExtra("відповідь", "Немає відповіді") }
            else {
                val inputNumber = number1.text.toString().toFloat() * number2.text.toString().toFloat()
                intent.putExtra("відповідь", inputNumber.toString())
            }
        }
    }

    private fun dil(intent: Intent){
        dlBtn.setOnClickListener{
            if(number1.text.isEmpty() || number2.text.isEmpty() || number2.text.equals("0")){
                intent.putExtra("відповідь", "Немає відповіді") }
            else {
                val inputNumber = number1.text.toString().toFloat() / number2.text.toString().toFloat()
                intent.putExtra("відповідь", inputNumber.toString())
            }
        }
    }

    private fun result(intent: Intent) {
        showResult.setOnClickListener {
            if (number1.text.isEmpty() || number2.text.isEmpty()) {
                intent.putExtra("відповідь", "Немає відповіді")
            }
            startActivity(intent)
        }
    }

    private fun clear(intent: Intent){
        clearBtn.setOnClickListener {
            number1.setText("")
            number2.setText("")
            intent.putExtra("відповідь", "Немає відповіді")
        }
    }
}

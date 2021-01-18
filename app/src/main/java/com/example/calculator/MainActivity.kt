package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var isNewOperator:Boolean = true
    private var oldNumber:String = ""
    private var operator:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if (isNewOperator)
            tvResult.text = ""
        isNewOperator = false
        var number:String = tvResult.text.toString()
        when(view.id){
            R.id.btn0 -> number += "0"
            R.id.btn1 -> number += "1"
            R.id.btn2 -> number += "2"
            R.id.btn3 -> number += "3"
            R.id.btn4 -> number += "4"
            R.id.btn5 -> number += "5"
            R.id.btn6 -> number += "6"
            R.id.btn7 -> number += "7"
            R.id.btn8 -> number += "8"
            R.id.btn9 -> number += "9"
            R.id.btnPlusMinus -> {
                number = if (number.toDouble() < 0)
                    (number.toDouble()*(-1)).toString()
                else
                    "-$number"
            }
            R.id.btnDot -> number+="."
        }
        tvResult.text = number
    }

    fun operatorEvent(view: View) {
        isNewOperator = true
        oldNumber = tvResult.text.toString()
        when(view.id){
            R.id.plus -> operator = "+"
            R.id.minus -> operator = "-"
            R.id.mul -> operator = "*"
            R.id.div -> operator = "/"
        }
    }

    fun equalEvent(view: View) {
        val newNumber:String = tvResult.text.toString()
        var result = 0.0
        when(operator){
            "+" -> result = oldNumber.toDouble() + newNumber.toDouble()
            "-" -> result = oldNumber.toDouble() - newNumber.toDouble()
            "*" -> result = oldNumber.toDouble() * newNumber.toDouble()
            "/" -> result = oldNumber.toDouble() / newNumber.toDouble()
        }
        tvResult.text = "$result"
    }

    fun clearEvent(view: View) {
        tvResult.text = ""
        isNewOperator = true
    }
    fun percentEvent(view: View) {
        val no:Double = (tvResult.text.toString()).toDouble() / 100
        tvResult.text =  "$no"
        isNewOperator = true
    }


}

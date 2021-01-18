package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var isNewOperator: Boolean = true
    private var oldNumber: String = ""
    private var operator: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberEvent(view: View) {
        if (isNewOperator)
            textViewResult.text = ""
        isNewOperator = false
        var number: String = textViewResult.text.toString()
        when (view.id) {
            R.id.button0 -> number += "0"
            R.id.button1 -> number += "1"
            R.id.button2 -> number += "2"
            R.id.button3 -> number += "3"
            R.id.button4 -> number += "4"
            R.id.button5 -> number += "5"
            R.id.button6 -> number += "6"
            R.id.button7 -> number += "7"
            R.id.button8 -> number += "8"
            R.id.button9 -> number += "9"
            R.id.buttonPlusMinus -> {
                number = if (number.toDouble() < 0)
                    (number.toDouble() * (-1)).toString()
                else
                    "-$number"
            }
            R.id.buttonDot -> number += "."
        }
        textViewResult.text = number
    }

    fun operatorEvent(view: View) {
        isNewOperator = true
        oldNumber = textViewResult.text.toString()
        when (view.id) {
            R.id.buttonPlus -> operator = "+"
            R.id.buttonMinus -> operator = "-"
            R.id.buttonMul -> operator = "*"
            R.id.buttonDiv -> operator = "/"
        }
    }

    fun equalEvent(view: View) {
        val newNumber: String = textViewResult.text.toString()
        var result = 0.0
        when (operator) {
            "+" -> result = oldNumber.toDouble() + newNumber.toDouble()
            "-" -> result = oldNumber.toDouble() - newNumber.toDouble()
            "*" -> result = oldNumber.toDouble() * newNumber.toDouble()
            "/" -> result = oldNumber.toDouble() / newNumber.toDouble()
        }
        textViewResult.text = "$result"
    }

    fun clearEvent(view: View) {
        textViewResult.text = ""
        isNewOperator = true
    }

    fun percentEvent(view: View) {
        val no: Double = (textViewResult.text.toString()).toDouble() / 100
        textViewResult.text = "$no"
        isNewOperator = true
    }
}


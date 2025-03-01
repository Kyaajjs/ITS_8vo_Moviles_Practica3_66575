package com.example.its_8vo_moviles_practica3_66575

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txtResult: TextView
    private var currentInput = ""
    private var memory: Double = 0.0
    private var operator: String? = null
    private var firstOperand: Double? = null

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        txtResult = findViewById(R.id.txtResult)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
        )
        buttons.forEach { id ->
            findViewById<Button>(id).setOnClickListener { appendNumber((it as Button).text.toString()) }
        }

        val operations = mapOf(
            R.id.btnAdd to "+", R.id.btnSubtract to "-",
            R.id.btnMultiply to "*", R.id.btnDivide to "/"
        )
        operations.forEach { (id, op) ->
            findViewById<Button>(id).setOnClickListener { setOperator(op) }
        }



        findViewById<Button>(R.id.btnEquals).setOnClickListener { calculateResult() }
        findViewById<Button>(R.id.btnClear).setOnClickListener { clearInput() }
        findViewById<Button>(R.id.btnMc).setOnClickListener { memory = 0.0 }
        findViewById<Button>(R.id.btnMr).setOnClickListener { txtResult.text = memory.toString() }
        findViewById<Button>(R.id.btnMPlus).setOnClickListener { memory += txtResult.text.toString().toDoubleOrNull() ?: 0.0 }
        findViewById<Button>(R.id.btnMMinus).setOnClickListener { memory -= txtResult.text.toString().toDoubleOrNull() ?: 0.0 }
    }

    private fun appendNumber(number: String) {
        currentInput += number
        txtResult.text = currentInput
    }

    private fun setOperator(op: String) {
        firstOperand = currentInput.toDoubleOrNull()
        operator = op
        currentInput = ""
    }

    private fun calculateResult() {
        val secondOperand = currentInput.toDoubleOrNull()
        if (firstOperand != null && secondOperand != null && operator != null) {
            val result = when (operator) {
                "+" -> firstOperand!! + secondOperand
                "-" -> firstOperand!! - secondOperand
                "*" -> firstOperand!! * secondOperand
                "/" -> if (secondOperand != 0.0) firstOperand!! / secondOperand else null
                else -> null
            }
            txtResult.text = result?.toString() ?: "Error"
            currentInput = result?.toString() ?: ""
            firstOperand = null
            operator = null
        }
    }

    private fun clearInput() {
        currentInput = ""
        txtResult.text = "0"
        firstOperand = null
        operator = null
    }
}
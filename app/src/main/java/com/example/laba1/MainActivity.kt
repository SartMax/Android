package com.example.laba1

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.udojava.evalex.Expression
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {

    var tvOutput: TextView? = null
    var tvInput: TextView? = null
    var Input: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnZero = findViewById<Button>(R.id.buttonNull)
        val btnOne = findViewById<Button>(R.id.buttonOne)
        val btnTwo = findViewById<Button>(R.id.buttonTwo)
        val btnThree = findViewById<Button>(R.id.buttonThree)
        val btnFour = findViewById<Button>(R.id.buttonFour)
        val btnFive = findViewById<Button>(R.id.buttonFive)
        val btnSix = findViewById<Button>(R.id.buttonSix)
        val btnSeven = findViewById<Button>(R.id.buttonSeven)
        val btnEight = findViewById<Button>(R.id.button8)
        val btnNine = findViewById<Button>(R.id.buttonNine)

        val btnDot = findViewById<Button>(R.id.buttonPoint)
        val btnDevide = findViewById<Button>(R.id.buttonDivide)
        val btnMultiplus = findViewById<Button>(R.id.buttonMultiplay)
        val btnMinus = findViewById<Button>(R.id.buttonMinus)
        val btnPlus = findViewById<Button>(R.id.buttonPlus)
        val btnPercent = findViewById<Button>(R.id.buttonPersent)
        val btnAC = findViewById<Button>(R.id.buttonAC)
        val btnDelete = findViewById<Button>(R.id.buttonDelete)
        val btnEquals = findViewById<Button>(R.id.buttonEqually)

        if (resources.configuration.orientation == ORIENTATION_LANDSCAPE) {
            val btnRightBracket = findViewById<Button>(R.id.buttonLeftbracket)
            val btnLeftBracket = findViewById<Button>(R.id.buttonRightbracket)
            val btnArrowUp = findViewById<Button>(R.id.buttonDegree)
            val btnE = findViewById<Button>(R.id.buttonE)
            val btnPI = findViewById<Button>(R.id.buttonPI)

            val btnSin = findViewById<Button>(R.id.buttonSin)
            val btnCos = findViewById<Button>(R.id.buttonCos)
            val btnTg = findViewById<Button>(R.id.buttonTg)
            val btnAsin = findViewById<Button>(R.id.buttonASin)
            val btnArccos = findViewById<Button>(R.id.buttonACos)
            val btnArctg = findViewById<Button>(R.id.buttonATg)
            val btnLog = findViewById<Button>(R.id.buttonLog)
            val btnFact = findViewById<Button>(R.id.buttonFact)
            val btnSqrt = findViewById<Button>(R.id.buttonSqrt)

            btnRightBracket.setOnClickListener { getSymbol("(") }
            btnLeftBracket.setOnClickListener { getSymbol(")") }
            btnArrowUp.setOnClickListener { getSymbol("^") }
            btnE.setOnClickListener { getSymbol("e") }
            btnPI.setOnClickListener { getSymbol("PI") }

            btnSin.setOnClickListener { getSymbol("sin(") }
            btnCos.setOnClickListener { getSymbol("cos(") }
            btnTg.setOnClickListener { getSymbol("tan(") }
            btnAsin.setOnClickListener { getSymbol("asin(") }
            btnArccos.setOnClickListener { getSymbol("acos(") }
            btnArctg.setOnClickListener { getSymbol("atan(") }
            btnLog.setOnClickListener { getSymbol("log(") }
            btnFact.setOnClickListener { getSymbol("FACT(") }
            btnSqrt.setOnClickListener { getSymbol("SQRT(") }

        }

        tvOutput = findViewById<TextView>(R.id.textviewout)
        tvInput = findViewById<TextView>(R.id.textviewinput)

        btnZero.setOnClickListener { getSymbol("0") }
        btnOne.setOnClickListener { getSymbol("1") }
        btnTwo.setOnClickListener { getSymbol("2") }
        btnThree.setOnClickListener { getSymbol("3") }
        btnFour.setOnClickListener { getSymbol("4") }
        btnFive.setOnClickListener { getSymbol("5") }
        btnSix.setOnClickListener { getSymbol("6") }
        btnSeven.setOnClickListener { getSymbol("7") }
        btnEight.setOnClickListener { getSymbol("8") }
        btnNine.setOnClickListener { getSymbol("9") }

        btnDot.setOnClickListener { getSymbol(".") }
        btnDevide.setOnClickListener { getSymbol("/") }
        btnMultiplus.setOnClickListener { getSymbol("*") }
        btnMinus.setOnClickListener { getSymbol("-") }
        btnPlus.setOnClickListener { getSymbol("+") }
        btnPercent.setOnClickListener { getSymbol("%") }
        btnAC.setOnClickListener { clearAll() }
        btnDelete.setOnClickListener { deleteSymbol() }
        btnEquals.setOnClickListener {
            try {
                getResult()
            } catch (error: Exception) {
                tvOutput?.text = "Error"
            }
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("input", Input)
        outState.putString("output", tvOutput?.text.toString())
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tvInput?.text = savedInstanceState.getString("input")
        tvOutput?.text = savedInstanceState.getString("output")
    }

    fun getSymbol(symbol: String) {
        if (Input == "Input") {
            Input = ""
        }
        Input += symbol
        tvInput?.text = Input
    }

    fun deleteSymbol() {
        Input = Input.dropLast(1)
        tvInput?.text = Input
    }

    fun clearAll() {
        Input = ""
        tvInput?.text = Input
        tvOutput?.text = ""
    }

    fun getResult() {
        try{
            try {
                val expression = Expression(Input)
                tvOutput?.text = expression.eval().toString()

            } catch (error: Exception) {
                Toast.makeText(applicationContext, "Invalid Output!!",
                    Toast.LENGTH_SHORT).show()
                tvOutput?.text = "wrong input"
            }
        }catch (error: ArithmeticException){
            tvOutput?.text = "can't divide by zero"
        }
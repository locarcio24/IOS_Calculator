package com.example.calculadora

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var valor1: Number = 0
        var valor2: Number
        val calcContent = findViewById<TextView>(R.id.textView)
        fun txtViewValue(): Number {
            return if (calcContent.text.toString().isEmpty() || calcContent.text == null) {
                calcContent.text = "0"
                0
            } else if (calcContent.text.contains(".")) {
                if (calcContent.text.last() == '.') {
                    calcContent.text = calcContent.text.dropLast(1)
                    calcContent.text.toString().toInt()
                } else {
                    calcContent.text.toString().toFloat()
                }
            } else {
                calcContent.text.toString().toInt()
            }
        }

        val hintView = findViewById<TextView>(R.id.hint)
        val btnClear = findViewById<Button>(R.id.clear_btn)
        val btnNeg = findViewById<Button>(R.id.neg_btn)
        val btnPrcntj = findViewById<Button>(R.id.prcntj_btn)
        val btnDiv = findViewById<Button>(R.id.div_btn)
        val btnMult = findViewById<Button>(R.id.multiply_btn)
        val btnRest = findViewById<Button>(R.id.restar_btn)
        val btnSuma = findViewById<Button>(R.id.sumar_btn)
        val btnResult = findViewById<Button>(R.id.result_btn)
        val btnComa = findViewById<Button>(R.id.coma_btn)
        val btn9 = findViewById<Button>(R.id.nueve_btn)
        val btn8 = findViewById<Button>(R.id.ocho_btn)
        val btn7 = findViewById<Button>(R.id.siete_btn)
        val btn6 = findViewById<Button>(R.id.seis_btn)
        val btn5 = findViewById<Button>(R.id.cinco_btn)
        val btn4 = findViewById<Button>(R.id.cuatro_btn)
        val btn3 = findViewById<Button>(R.id.tres_btn)
        val btn2 = findViewById<Button>(R.id.dos_btn)
        val btn1 = findViewById<Button>(R.id.uno_btn)
        val btn0 = findViewById<Button>(R.id.cero_btn)
        btnClear.setOnClickListener {
            calcContent.text = "0"
            hintView.text = ""
        }
        btnPrcntj.setOnClickListener {
            calcContent.text = (calcContent.text.toString().toFloat() / 100).toString()
        }
        btnNeg.setOnClickListener {
            if (calcContent.text.toString().contains("-")) calcContent.text =
                calcContent.text.toString().replace("-", "")
            else calcContent.text = "-${calcContent.text}"
        }
        btnDiv.setOnClickListener {
            valor1 = txtViewValue()
            calcContent.text = ""
            hintView.text = "÷"
        }
        btnMult.setOnClickListener {
            valor1 = txtViewValue()
            calcContent.text = ""
            hintView.text = "x"
        }
        btnRest.setOnClickListener {
            valor1 = txtViewValue()
            calcContent.text = ""
            hintView.text = "—"
        }
        btnSuma.setOnClickListener {
            valor1 = txtViewValue()
            calcContent.text = ""
            hintView.text = "+"
        }
        btnComa.setOnClickListener {
            if (!calcContent.text.contains(".")) calcContent.append(".")
        }
        btn9.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "9"
            else calcContent.append("9")
        }
        btn8.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "8"
            else calcContent.append("8")
        }
        btn7.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "7"
            else calcContent.append("7")
        }
        btn6.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "6"
            else calcContent.append("6")
        }
        btn5.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "5"
            else calcContent.append("5")
        }
        btn4.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "4"
            else calcContent.append("4")
        }
        btn3.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "3"
            else calcContent.append("3")
        }
        btn2.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "2"
            else calcContent.append("2")
        }
        btn1.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "1"
            else calcContent.append("1")
        }
        btn0.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "0"
            else calcContent.append("0")
        }
        btnResult.setOnClickListener {
            valor2 = txtViewValue()
            when (hintView.text) {
                "—" -> calcContent.text = (valor1.toFloat() - valor2.toFloat()).toString()
                "+" -> calcContent.text = (valor1.toFloat() + valor2.toFloat()).toString()
                "÷" -> calcContent.text = (valor1.toFloat() / valor2.toFloat()).toString()
                "x" -> calcContent.text = (valor1.toFloat() * valor2.toFloat()).toString()
            }
            if (calcContent.text.takeLast(2).toString() == ".0") {
                calcContent.text = calcContent.text.dropLast(2)
            }
            hintView.text = "="
        }
    }
}
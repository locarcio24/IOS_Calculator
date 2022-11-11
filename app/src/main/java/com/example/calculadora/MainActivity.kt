package com.example.calculadora

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var valor1: Number = 0
        var valor2: Number
        val calcContent = binding.textView
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

        val hintView = binding.hint
        binding.clearBtn.setOnClickListener {
            calcContent.text = "0"
            hintView.text = ""
        }
        binding.prcntjBtn.setOnClickListener {
            calcContent.text = (calcContent.text.toString().toFloat() / 100).toString()
        }
        binding.negBtn.setOnClickListener {
            if (calcContent.text.toString().contains("-")) calcContent.text =
                calcContent.text.toString().replace("-", "")
            else calcContent.text = "-${calcContent.text}"
        }
        binding.divBtn.setOnClickListener {
            valor1 = txtViewValue()
            calcContent.text = ""
            hintView.text = "÷"
        }
        binding.multiplyBtn.setOnClickListener {
            valor1 = txtViewValue()
            calcContent.text = ""
            hintView.text = "x"
        }
        binding.restarBtn.setOnClickListener {
            valor1 = txtViewValue()
            calcContent.text = ""
            hintView.text = "—"
        }
        binding.sumarBtn.setOnClickListener {
            valor1 = txtViewValue()
            calcContent.text = ""
            hintView.text = "+"
        }
        binding.comaBtn.setOnClickListener {
            if (!calcContent.text.contains(".")) calcContent.append(".")
        }
        binding.nueveBtn.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "9"
            else calcContent.append("9")
        }
        binding.ochoBtn.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "8"
            else calcContent.append("8")
        }
        binding.sieteBtn.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "7"
            else calcContent.append("7")
        }
        binding.seisBtn.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "6"
            else calcContent.append("6")
        }
        binding.cincoBtn.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "5"
            else calcContent.append("5")
        }
        binding.cuatroBtn.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "4"
            else calcContent.append("4")
        }
        binding.tresBtn.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "3"
            else calcContent.append("3")
        }
        binding.dosBtn.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "2"
            else calcContent.append("2")
        }
        binding.unoBtn.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "1"
            else calcContent.append("1")
        }
        binding.ceroBtn.setOnClickListener {
            if (calcContent.text.contains("0") && calcContent.length() == 1) calcContent.text = "0"
            else calcContent.append("0")
        }
        binding.resultBtn.setOnClickListener {
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
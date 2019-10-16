package com.luati.unicubos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.constraint_layout.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)

        resultTXT.visibility = View.INVISIBLE

        calculateBTN.setOnClickListener {

            var heigth = heightEDTX.text.toString()
            var weight = weightEDTX.text.toString()

            if (isNotNullOrNotEmpty(heigth)) {
                Toast.makeText(this, "Digite um valor válido de altura!", Toast.LENGTH_LONG)
                    .show()
            } else if (isNotNullOrNotEmpty(weight)) {
                Toast.makeText(this, "Digite um valor válido de peso!", Toast.LENGTH_LONG)
                    .show()
            } else {
                var imc = weight.toFloat() / (heigth.toFloat() * heigth.toFloat())

                resultTXT.visibility = View.VISIBLE

                var numberFormat = DecimalFormat("#.##")
                numberFormat.roundingMode = RoundingMode.CEILING

                resultTXT.text = "Seu IMC é igual a " + numberFormat.format(imc) + "\n" + isAllRight(imc)
            }

            val inputManager: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                currentFocus.windowToken,
                InputMethodManager.SHOW_FORCED
            )
        }

        clearBTN.setOnClickListener {
            heightEDTX.setText("")
            weightEDTX.setText("")
            resultTXT.visibility = View.INVISIBLE
        }
    }

    fun isNotNullOrNotEmpty(str: String?): Boolean {
        if (str != null && str.isNotEmpty() && str.toFloat() > 0)
            return false
        return true
    }

    fun isAllRight(number: Float): String {
        if (number <= 18.5) {
            return "Você está abaixo do peso ideal =("
        } else if (number >= 18.6 && number <= 24.9) {
            return "Parabéns! Você está com o peso ideal! \\o/"
        } else {
            return "Você está acima do peso ideal =("
        }
    }
}

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
        initListener()
    }

    private fun initListener() {
        calculateBTN?.setOnClickListener() {

            if (heightEDTX?.text.toString().trim() == "." || isNotNullOrNotEmpty(heightEDTX?.text.toString())) {
                Toast.makeText(this, "Digite um valor válido de altura!", Toast.LENGTH_LONG)
                    .show()
            } else if (weightEDTX?.text.toString().trim() == "." || isNotNullOrNotEmpty(weightEDTX?.text.toString())) {
                Toast.makeText(this, "Digite um valor válido de peso!", Toast.LENGTH_LONG)
                    .show()
            } else {
                resultTXT.visibility = View.VISIBLE

                var numberFormat = DecimalFormat("#.##")
                numberFormat.roundingMode = RoundingMode.CEILING

                var imc = getValues()

                resultTXT.text =
                    "Seu IMC é igual a " + numberFormat.format(imc) + "\n" + isAllRight(imc)
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

    private fun isNotNullOrNotEmpty(str: String?): Boolean {
        if (str != null && str.isNotEmpty() && str.toFloat() > 0)
            return false
        return true
    }

    private fun isAllRight(number: Float): String {
        return when(number) {
            in 0f..18.5f -> "Você está abaixo do peso ideal =("
            in 18.6f..24.9f -> "Parabéns! Você está com o peso ideal! \\o/"
            else -> "Você está acima do peso ideal =("
        }
    }

    private fun getValues(): Float {
        var weight: Float = weightEDTX?.text.toString()?.toFloat() ?: 1f
        var height: Float = heightEDTX?.text.toString()?.toFloat() ?: 0f

        return calculateIMC(weight, height)
    }

    private fun calculateIMC(weigth: Float, height: Float) = weigth / (height * height)
}

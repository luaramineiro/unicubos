package com.luati.unicubos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.constraint_layout.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)

        calculateBTN.setOnClickListener {
            var heigth = heightEDTX.text.toString().toFloat()
            var weight = weightEDTX.text.toString().toFloat()

            if (heigth <= 0) {
                Toast.makeText(this, "Digite um valor de altura > 0 ", Toast.LENGTH_LONG)
                    .show()
            }
            else if (weight <= 0) {
                Toast.makeText(this, "Digite um valor de peso > 0 ", Toast.LENGTH_LONG)
                    .show()
            }
            else {
                var imc = weight / (heigth * heigth)
                Toast.makeText(this, "Seu IMC é igual a " + imc.toString(), Toast.LENGTH_LONG)
                    .show()
            }
        }

        clearBTN.setOnClickListener {
            heightEDTX.setText("")
            weightEDTX.setText("")
        }
    }

}

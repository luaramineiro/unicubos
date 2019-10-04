package com.luati.unicubos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Picasso
            .get()
            .load("https://img.huffingtonpost.com/asset/5d0a4310210000dc18f3cf4b.jpeg?ops=scalefit_630_noupscale")
            .into(imageDogs)
    }

    override fun onStart() {
        super.onStart()
        toast("Método onStart!!")
    }

    override fun onRestart() {
        super.onRestart()
        toast("Método onRestart!!")
    }

    override fun onResume() {
        super.onResume()
        toast("Método onResume!!")
    }

    override fun onDestroy() {
        super.onDestroy()
        toast("Método onDestroy!!")
    }

    private fun toast(text:String) = Toast.makeText(this, text,Toast.LENGTH_LONG).show()
}

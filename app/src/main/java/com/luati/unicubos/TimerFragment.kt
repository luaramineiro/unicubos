package com.luati.unicubos


import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_timer.*


/**
 * A simple [Fragment] subclass.
 */
class TimerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_timer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {

        initBTN.setOnClickListener {
            countTime()
        }
    }

    private fun countTime() {
        for (count in 1..30) {
            try {
                Thread.sleep(1000)
            } catch (e: InterruptedException) {    //Erro na execução.
                Log.e("ERRO", count.toString())
            }

            timeTXT.text = "00 00 " + formatNumberToString(count)
            Log.e("Teste", count.toString())
        }

    }

    private fun formatNumberToString(number: Int): String =
        if (number < 10) "0 {$number.toString()}" else number.toString()
}

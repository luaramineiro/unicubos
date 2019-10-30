package com.luati.unicubos


import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_timer.*

import android.widget.Chronometer


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


            object : CountDownTimer(30000, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    timeTXT.text = ((timeTXT.text.toString().toInt() + 1) / 1000).toString()
                }

                override fun onFinish() {
                    timeTXT.text = "00 00 00"
                }
            }.start()
        }
    }
}

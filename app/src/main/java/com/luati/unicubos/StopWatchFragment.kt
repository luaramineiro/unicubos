package com.luati.unicubos


import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_stop_watch.*

/**
 * A simple [Fragment] subclass.
 */
class StopWatchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stop_watch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        var objectCountDownTimer = initCountDownTimer(0)

        initBTN.setOnClickListener {
            val sumTime = (secondEDTX.text.toString().toLong() +
                    (minuteEDTX.text.toString().toLong()*60) +
                    (hourEDTX.text.toString().toLong())*3600)*1000

            objectCountDownTimer = initCountDownTimer(sumTime)
            objectCountDownTimer.start()
            initBTN?.isEnabled = false
        }

        stopBTN.setOnClickListener{
            initBTN?.isEnabled = true
            objectCountDownTimer.cancel()
        }

        clearBTN.setOnClickListener{
            objectCountDownTimer.cancel()
            hourEDTX.setText("00")
            minuteEDTX.setText("00")
            secondEDTX.setText("00")
        }
    }

    private fun initCountDownTimer(millisInFuture: Long): CountDownTimer {
        return object : CountDownTimer(millisInFuture, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val sumTime = millisUntilFinished / 1000
                var stringSecond = "00"
                var stringMinute = "00"
                var stringhour = "00"

                // Seconds
                if (sumTime < 60) {
                    stringSecond = formatNumberToString(sumTime.toInt())
                }
                // Minutes
                else if ((sumTime >= 60) && (sumTime < 3600)) {
                    val intMinute = (sumTime / 60)?.toInt()
                    val intSecond = (sumTime - (intMinute*60))?.toInt()

                    stringMinute = formatNumberToString(intMinute)
                    stringSecond = formatNumberToString(intSecond)
                }
                // Hours
                else {
                    val intHour : Int = (sumTime / 3600)?.toInt()
                    val intMinute = ((sumTime - (intHour * 3600)) / 60)?.toInt()
                    val intSecond = (sumTime - (intHour * 3600) - (intMinute*60))?.toInt()

                    stringSecond = formatNumberToString(intSecond)
                    stringMinute = formatNumberToString(intMinute)
                    stringhour = formatNumberToString(intHour)
                }

                secondEDTX.setText(stringSecond)
                minuteEDTX.setText(stringMinute)
                hourEDTX.setText(stringhour)
            }

            override fun onFinish() {
                initBTN?.isEnabled = true
                secondEDTX.setText("00")
                minuteEDTX.setText("00")
                hourEDTX.setText("00")
            }
        }
    }

    private fun formatNumberToString(number : Int): String = if (number < 10) "0 {$number.toString()}" else number.toString()
}

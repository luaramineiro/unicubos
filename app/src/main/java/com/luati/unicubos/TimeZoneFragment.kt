package com.luati.unicubos


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_time_zone.*

/**
 * A simple [Fragment] subclass.
 */
class TimeZoneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_zone, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = arrayListOf(
            TimeZoneModel(
                name = "Brasil",
                timezone = "GMT-",
                time = 3
            ),
            TimeZoneModel(
                name = "Polinésia",
                timezone = "UTC-",
                time = 4
            )
        )

        recyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView?.adapter = TimeZoneRecyclerAdapter(list)
    }
}

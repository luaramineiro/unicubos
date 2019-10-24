package com.luati.unicubos

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.appbar.AppBarLayout

class MainPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragmentList : ArrayList<Fragment> = arrayListOf<Fragment>()
    private val titleList : ArrayList<String> = arrayListOf<String>()

    init {
        titleList.add("Timer")
        titleList.add("Stopwatch")
        fragmentList.add(TimerFragment())
        fragmentList.add(StopWatchFragment())
    }

    override fun getItem(position: Int): Fragment  = fragmentList[position]

    override fun getCount(): Int = fragmentList.size

    override fun getPageTitle(position: Int): CharSequence? = titleList[position]
}
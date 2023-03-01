package com.example.scorecheckingapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FootballLeagueViewPagerAdapter(supportFragmentManager: FragmentManager, var tabCount : Int) : FragmentStatePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return  tabCount
    }

    override fun getItem(position: Int): Fragment {
        TODO("Not yet implemented")
    }
}
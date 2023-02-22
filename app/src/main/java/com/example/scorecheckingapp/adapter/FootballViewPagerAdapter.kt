package com.example.scorecheckingapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.scorecheckingapp.fragments.Football.FootballRecentScoreFragment
import com.example.scorecheckingapp.fragments.Football.FootballTodayScoreFragment
import com.example.scorecheckingapp.fragments.Football.FootballUpcomingScoreFragment

class FootballViewPagerAdapter(supportFragmentManager: FragmentManager, var tabCount : Int) : FragmentStatePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return  tabCount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> FootballRecentScoreFragment()
            1 -> FootballTodayScoreFragment()
            2 -> FootballUpcomingScoreFragment()
            else -> FootballTodayScoreFragment()
        }
    }
    override fun getPageTitle(position: Int): CharSequence{
        return when(position){
            0 -> "Recent"
            1 -> "Today"
            2 -> "Upcoming"
            else -> "Today"
        }
    }



}
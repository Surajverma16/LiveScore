package com.example.scorecheckingapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.scorecheckingapp.fragments.Cricket.CricketRecentScoreFragment
import com.example.scorecheckingapp.fragments.Cricket.CricketTodayScoreFragment
import com.example.scorecheckingapp.fragments.Cricket.CricketUpcomingScoreFragment

class CricketViewPagerAdapter(suppoertFragmentManager: FragmentManager, var tabCount : Int) : FragmentStatePagerAdapter(suppoertFragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
    return when(position){
        0 -> CricketRecentScoreFragment()
        1 -> CricketTodayScoreFragment()
        2 -> CricketUpcomingScoreFragment()
        else -> CricketTodayScoreFragment()
    }
    }

    override fun getPageTitle(position: Int): CharSequence? {
            return when(position){
                0 -> "Recent"
                1 -> "Today"
                2 -> "Upcoming"
                else -> "Today"
            }
    }
}
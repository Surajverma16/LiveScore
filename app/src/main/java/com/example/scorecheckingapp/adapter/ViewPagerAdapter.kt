package com.example.scorecheckingapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.scorecheckingapp.fragments.Football.RecentFragment
import com.example.scorecheckingapp.fragments.Football.TodayScoreFragment
import com.example.scorecheckingapp.fragments.Football.UpcomingFragment

class ViewPagerAdapter(supportFragmentManager: FragmentManager , var tabCount : Int) : FragmentStatePagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return  tabCount
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> RecentFragment()
            1 -> TodayScoreFragment()
            2 -> UpcomingFragment()
            else -> TodayScoreFragment()
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
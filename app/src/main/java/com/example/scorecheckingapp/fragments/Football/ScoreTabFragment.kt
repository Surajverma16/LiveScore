package com.example.scorecheckingapp.fragments.Football

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.activity.FootballActivity
import com.example.scorecheckingapp.databinding.FragmentScoreTabBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.example.scorecheckingapp.adapter.ViewPagerAdapter as ViewPagerAdapter

class ScoreTabFragment : Fragment() {

        lateinit var binding: FragmentScoreTabBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentScoreTabBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as FootballActivity).binding.bottomNavMenu.menu.getItem(0).isChecked = true

    }


    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // set the content of the adaptr in the fragment of the tab
        binding.scoreViewPager.adapter = ViewPagerAdapter(childFragmentManager, 3)
        binding.scoreViewPager.offscreenPageLimit = 3

        // Set tab position on starting the app
        val ab = binding.scoreTab.setScrollPosition(1,0f,true)
        binding.scoreViewPager.setCurrentItem(1)

        // setting the view pager for the tab layout
        binding.scoreTab.setupWithViewPager(binding.scoreViewPager)
    }



}
package com.example.scorecheckingapp.fragments.Football

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.databinding.FragmentScoreTabBinding
import com.google.android.material.tabs.TabLayout
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
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.scoreViewPager.adapter = ViewPagerAdapter(childFragmentManager,3)
        binding.scoreViewPager.offscreenPageLimit = 3

        binding.scoreTab.setupWithViewPager(binding.scoreViewPager)
    }
}
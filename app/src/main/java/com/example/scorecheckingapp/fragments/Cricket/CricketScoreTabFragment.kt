package com.example.scorecheckingapp.fragments.Cricket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.scorecheckingapp.activity.MainActivity
import com.example.scorecheckingapp.adapter.CricketViewPagerAdapter
import com.example.scorecheckingapp.databinding.FragmentCricketScoreTabBinding
class CricketScoreTabFragment : Fragment() {

    lateinit var binding: FragmentCricketScoreTabBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCricketScoreTabBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).binding.bottomNavMenu.menu.getItem(0).isChecked = true

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.scoreViewPager.adapter = CricketViewPagerAdapter(childFragmentManager,3)
        binding.scoreViewPager.offscreenPageLimit = 3

        binding.scoreTabCricket.setScrollPosition(1,0f,true)
        binding.scoreViewPager.setCurrentItem(1)

        binding.scoreTabCricket.setupWithViewPager(binding.scoreViewPager)
    }
}
package com.example.scorecheckingapp.fragments.Cricket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.activity.MainActivity
import com.example.scorecheckingapp.adapter.FootballLeagueAdapter
import com.example.scorecheckingapp.adapter.FootballScoreAdapter
import com.example.scorecheckingapp.dataClass.FootballScoreDataClass
import com.example.scorecheckingapp.databinding.FragmentCricketTodayScoreBinding

class CricketTodayScoreFragment : Fragment() {

    lateinit var binding: FragmentCricketTodayScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCricketTodayScoreBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val displatArray =ArrayList<FootballScoreDataClass>()


//        binding.cricketTodayScoreRecyclerview.adapter = FootballLeagueAdapter((activity as MainActivity).globalList , requireContext())

        binding.cricketTodayScoreRecyclerview.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }
}
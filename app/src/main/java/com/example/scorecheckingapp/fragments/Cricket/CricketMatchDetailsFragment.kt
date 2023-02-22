package com.example.scorecheckingapp.fragments.Cricket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.dataClass.FootballScoreDataClass
import com.example.scorecheckingapp.databinding.FragmentCricketMatchDetailsBinding
import com.example.scorecheckingapp.databinding.FragmentFootballMatchDetailsBinding

class CricketMatchDetailsFragment(val footballScoreDataClass: FootballScoreDataClass) : Fragment() {

    lateinit var binding: FragmentFootballMatchDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFootballMatchDetailsBinding.inflate(layoutInflater,container,false)
        binding.detailsTiming.text = footballScoreDataClass.time
        binding.detailsFirstTeamName.text = footballScoreDataClass.firstTeamName
        binding.detailsSecondTeamName.text = footballScoreDataClass.secondTeamName
        binding.detailsFirstTeamImage.setImageResource(footballScoreDataClass.firstTeamImage)
        binding.detailsSecondTeamImage.setImageResource(footballScoreDataClass.secondTeamImage)
        binding.detailsScoreFirstTeam.text = footballScoreDataClass.firstTeamScore.toString()
        binding.detailsScoreSecondTeam.text = footballScoreDataClass.secondTeamScore.toString()
        return binding.root
    }


}
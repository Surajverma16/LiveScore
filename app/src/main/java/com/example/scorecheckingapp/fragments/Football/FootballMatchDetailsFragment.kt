package com.example.scorecheckingapp.fragments.Football

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.scorecheckingapp.API.matchApi.Event
import com.example.scorecheckingapp.dataClass.FootballScoreDataClass
import com.example.scorecheckingapp.databinding.FragmentFootballMatchDetailsBinding

class FootballMatchDetailsFragment(val event : Event) : Fragment() {
  lateinit var binding: FragmentFootballMatchDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFootballMatchDetailsBinding.inflate(layoutInflater,container,false)
        binding.detailsTiming.text = event.Eps
        binding.detailsFirstTeamName.text = event.T1[0].Nm
        binding.detailsSecondTeamName.text = event.T2[0].Nm
        Glide.with(requireContext())
            .load("https://lsm-static-prod.livescore.com/medium/${event.T1[0].Img}")
            .into(binding.detailsFirstTeamImage)
        Glide.with(requireContext())
            .load("https://lsm-static-prod.livescore.com/medium/${event.T2[0].Img}")
            .into(binding.detailsSecondTeamImage)
        binding.detailsScoreFirstTeam.text = event.Tr1
        binding.detailsScoreSecondTeam.text = event.Tr2
        return binding.root
    }
}
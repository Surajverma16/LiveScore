package com.example.scorecheckingapp.fragments.Football

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.scorecheckingapp.dataClass.FootballScoreDataClass
import com.example.scorecheckingapp.databinding.FragmentFootballMatchDetailsBinding

class MatchDetailsFragment : Fragment() {
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
        val bundle   =   arguments?.getParcelable<FootballScoreDataClass>("Key" )
        if (bundle!= null) {
            binding.detailsTiming.text = bundle?.time
            binding.detailsFirstTeamImage.setImageResource(bundle!!.firstTeamImage)
            binding.detailsSecondTeamImage.setImageResource(bundle!!.secondTeamImage)
            binding.detailsFirstTeamName.text = bundle.firstTeamName
            binding.detailsSecondTeamName.text = bundle.secondTeamName
            binding.detailsScoreFirstTeam.text = bundle.firstTeamScore.toString()
            binding.detailsScoreSecondTeam.text = bundle.secondTeamScore.toString()

        }
        return binding.root
    }
}
package com.example.scorecheckingapp.fragments.Cricket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.scorecheckingapp.API.CricketApi.Event
import com.example.scorecheckingapp.databinding.FragmentCricketMatchDetailsBinding
import com.example.scorecheckingapp.databinding.FragmentFootballMatchDetailsBinding

class CricketMatchDetailsFragment(val event: Event) : Fragment() {

    lateinit var binding: FragmentCricketMatchDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        /*holder.matchType.text = cricketArray[position].EtTx
        holder.teamOneName.text = cricketArray[position].T1[0].Nm
        holder.teamTwoName.text = cricketArray[position].T2[0].Nm
        holder.matchSituation.text= cricketArray[position].ECo
        holder.teamOneScore.text = cricketArray[position].Tr1C1.toString()
        holder.teamTwoScore.text = cricketArray[position].Tr2C1.toString()
*/
        // Inflate the layout for this fragment
        binding = FragmentCricketMatchDetailsBinding.inflate(layoutInflater,container,false)
        binding.matchTypeText.text = event.EtTx
        binding.team1NameText.text = event.T1[0].Nm
        binding.team2NameText.text = event.T2[0].Nm
        binding.matchSituationText.text = event.ECo
        binding.team1ScoreText.text = event.Tr1C1.toString()
        binding.team2ScoreText.text = event.Tr2C1.toString()
        return binding.root
    }


}
package com.example.scorecheckingapp.fragments.Cricket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.activity.MainActivity
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

        for (i in 0..10){
            displatArray.add(FootballScoreDataClass("Live",R.drawable.india,R.drawable.australia,"India","Australia",225-5,123/7))
            displatArray.add(FootballScoreDataClass("Live",R.drawable.zimbabwe,R.drawable.new_zeland,"Zimbabwe","New Zeland",212, 350))
        }

        binding.cricketTodayScoreRecyclerview.adapter = FootballScoreAdapter(displatArray,requireContext(),object : FootballScoreAdapter.onSingleItemClick{
            override fun clicked(footballScoreDataClass: FootballScoreDataClass) {
                (context as MainActivity).supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container,CricketMatchDetailsFragment(footballScoreDataClass))
                    addToBackStack(null)
                    commit()
                }

            }

        })

        binding.cricketTodayScoreRecyclerview.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }
}
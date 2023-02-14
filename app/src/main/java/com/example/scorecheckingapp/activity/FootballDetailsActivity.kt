package com.example.scorecheckingapp.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.scorecheckingapp.dataClass.FootballScoreDataClass
import com.example.scorecheckingapp.databinding.ActivityFootballDetailsBinding

class FootballDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityFootballDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityFootballDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle : FootballScoreDataClass?  = intent?.getParcelableExtra("Key")
        if(bundle!= null){
            binding.detailsTiming.text = bundle.time
            binding.detailsFirstTeamImage.setImageResource(bundle.firstTeamImage)
            binding.detailsSecondTeamImage.setImageResource(bundle.secondTeamImage)
            binding.detailsFirstTeamName.text = bundle.firstTeamName
            binding.detailsSecondTeamName.text = bundle.secondTeamName
            binding.detailsScoreFirstTeam.text = bundle.firstTeamScore.toString()
            binding.detailsScoreSecondTeam.text = bundle.secondTeamScore.toString()


        }


    }
}
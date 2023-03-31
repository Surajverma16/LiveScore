package com.example.scorecheckingapp.fragments.Football

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.API.matchApi.Score
import com.example.scorecheckingapp.API.matchApi.Stage
import com.example.scorecheckingapp.adapter.FootballLeagueDetailAdapter
import com.example.scorecheckingapp.databinding.FragmentFootballLeagueDetailsBinding
import com.example.scorecheckingapp.interfaceApi.LeagueDetailsInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class FootballLeagueDetailsFragment(val league: Stage) : Fragment() {

lateinit var binding: FragmentFootballLeagueDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFootballLeagueDetailsBinding.inflate(layoutInflater,container,false)
        getApiData()
        return binding.root
    }

    fun getApiData(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://livescore6.p.rapidapi.com/matches/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LeagueDetailsInterface::class.java)

        val retrofitBody = retrofit.getLeagueDetails(
            "b72713c116msh3868c671703c21dp15679bjsn6f00e94a7fc0",
            "livescore6.p.rapidapi.com",
            "soccer",
            league.Ccd,
            TimeZone.getTimeZone("GMT+05:30").toString()
        )

        retrofitBody.enqueue(object : Callback<Score?> {
            override fun onResponse(call: Call<Score?>, response: Response<Score?>) {
                val responseBody = response.body()!!
                binding.progressBar.visibility = View.GONE
                binding.recyclerViewLeague.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                binding.recyclerViewLeague.adapter = FootballLeagueDetailAdapter(responseBody.Stages, requireContext())
            }

            override fun onFailure(call: Call<Score?>, t: Throwable) {
                Log.d("FailureLeague", t.localizedMessage)
            }
        })
    }


}
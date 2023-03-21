package com.example.scorecheckingapp.fragments.Cricket

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.API.CricketApi.CricketScoreApiInterface
import com.example.scorecheckingapp.API.CricketApi.Stage
import com.example.scorecheckingapp.API.CricketApi.cricket
import com.example.scorecheckingapp.API.matchApi.ApiInterface
import com.example.scorecheckingapp.API.matchApi.BASE_URL
import com.example.scorecheckingapp.API.matchApi.Score
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.activity.MainActivity
import com.example.scorecheckingapp.adapter.CricketLeagueAdapter
import com.example.scorecheckingapp.adapter.FootballLeagueAdapter
import com.example.scorecheckingapp.adapter.FootballScoreAdapter
import com.example.scorecheckingapp.dataClass.FootballScoreDataClass
import com.example.scorecheckingapp.databinding.FragmentCricketTodayScoreBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CricketTodayScoreFragment : Fragment() {

    lateinit var binding: FragmentCricketTodayScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCricketTodayScoreBinding.inflate(layoutInflater,container,false)
        getApiData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun getApiData() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://livescore6.p.rapidapi.com/matches/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CricketScoreApiInterface::class.java)


        val retrofitData = retrofit.getScore(
            "cricket",
            SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date()),
            "5.5",
            "0556ba5f2bmshb44144c24b34dd9p19186cjsne46d41378f92",
            "livescore6.p.rapidapi.com"
        )
        retrofitData.enqueue(object : Callback<cricket> {
            override fun onResponse(call: Call<cricket>, response: Response<cricket>) {
                val responseBody = response.body()!!
                binding.progressBar.visibility = View.GONE
                binding.cricketTodayScoreRecyclerview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                binding.cricketTodayScoreRecyclerview.adapter = CricketLeagueAdapter(responseBody.Stages, requireContext())
            }
            override fun onFailure(call: Call<cricket>, t: Throwable) {
                Log.d("Failure", t.localizedMessage!!)
            }
        })
    }
}
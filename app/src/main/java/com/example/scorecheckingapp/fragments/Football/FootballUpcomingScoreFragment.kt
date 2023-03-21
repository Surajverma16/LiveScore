package com.example.scorecheckingapp.fragments.Football

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.API.matchApi.ApiInterface
import com.example.scorecheckingapp.API.matchApi.BASE_URL
import com.example.scorecheckingapp.API.matchApi.Score
import com.example.scorecheckingapp.adapter.FootballLeagueAdapter
import com.example.scorecheckingapp.databinding.FragmentFootballUpcomingScoreBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class FootballUpcomingScoreFragment : Fragment() {

    lateinit var binding: FragmentFootballUpcomingScoreBinding
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getApiData()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFootballUpcomingScoreBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getApiData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)


        val retrofitData = retrofit.getScore(
            LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyyyMMdd")),
            "football",
            "5.5",
            "0556ba5f2bmshb44144c24b34dd9p19186cjsne46d41378f92",
            "livescore6.p.rapidapi.com"
        )
        retrofitData.enqueue(object : Callback<Score> {
            override fun onResponse(call: Call<Score>, response: Response<Score>) {
                val responseBody = response.body()!!
                binding.progressBar.visibility = View.GONE
                binding.footballUpcomingRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                binding.footballUpcomingRecyclerView.adapter = FootballLeagueAdapter(responseBody.Stages , requireContext())
            }
            override fun onFailure(call: Call<Score>, t: Throwable) {
                Log.d("Failure", t.localizedMessage!!)
            }
        })
    }







}

/*
        binding.footballUpcomingRecyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.VERTICAL,false)
        binding.footballUpcomingRecyclerView.adapter = FootballScoreAdapter(displayArray, requireContext(),object : FootballScoreAdapter.onSingleItemClick{
            override fun clicked(footballScoreDataClass: FootballScoreDataClass) {
                (context as MainActivity).supportFragmentManager.beginTransaction().apply {
                    replace(R.id.fragment_container, FootballMatchDetailsFragment(footballScoreDataClass))
                    addToBackStack(null)
                    commit()
                }
            }

        })*/
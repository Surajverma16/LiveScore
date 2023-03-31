package com.example.scorecheckingapp.fragments.Cricket

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.interfaceApi.CricketScoreApiInterface
import com.example.scorecheckingapp.API.CricketApi.cricket
import com.example.scorecheckingapp.adapter.CricketLeagueAdapter
import com.example.scorecheckingapp.databinding.FragmentCricketRecentScoreBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class CricketRecentScoreFragment : Fragment() {

    lateinit var binding: FragmentCricketRecentScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCricketRecentScoreBinding.inflate(layoutInflater,container,false)
        getApiData()
        return binding.root
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun getApiData() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://livescore6.p.rapidapi.com/matches/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CricketScoreApiInterface::class.java)


        val retrofitData = retrofit.getScore(
            "cricket",
            LocalDate.now().plusDays(-1).format(DateTimeFormatter.ofPattern("yyyyMMdd")),
            "5.5",
            "0556ba5f2bmshb44144c24b34dd9p19186cjsne46d41378f92",
            "livescore6.p.rapidapi.com"
        )
        retrofitData.enqueue(object : Callback<cricket> {
            override fun onResponse(call: Call<cricket>, response: Response<cricket>) {
                val responseBody = response.body()!!
                binding.progressBar.visibility = View.GONE
                binding.cricketRecentScoreRecyclerview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                binding.cricketRecentScoreRecyclerview.adapter = CricketLeagueAdapter(responseBody.Stages, requireContext())
            }
            override fun onFailure(call: Call<cricket>, t: Throwable) {
                Log.d("Failure", t.localizedMessage!!)
            }
        })
    }

}
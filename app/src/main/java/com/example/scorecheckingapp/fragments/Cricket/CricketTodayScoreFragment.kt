package com.example.scorecheckingapp.fragments.Cricket

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.API.matchApi.ApiInterface
import com.example.scorecheckingapp.API.matchApi.BASE_URL
import com.example.scorecheckingapp.API.matchApi.Score
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.activity.MainActivity
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
        // Inflate the layout for this fragment
        binding = FragmentCricketTodayScoreBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val displatArray =ArrayList<FootballScoreDataClass>()


//        binding.cricketTodayScoreRecyclerview.adapter = FootballLeagueAdapter((activity as MainActivity).globalList , requireContext())

        binding.cricketTodayScoreRecyclerview.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    }

   /* fun getApiData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)


        val retrofitData = retrofit.getScore(
            SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date()),
            "football",
            "5.5",
            "3eec2cda7cmsh0b270ac72d231f3p14a1eajsnb49154bb7c2e",
            "livescore6.p.rapidapi.com"
        )
        retrofitData.enqueue(object : Callback<Score> {
            override fun onResponse(call: Call<Score>, response: Response<Score>) {
                val responseBody = response.body()!!
                binding.cricketTodayScoreRecyclerview.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutMana(responseBody.Stages , requireConteger.VERTICAL,false)
                binding.cricketTodayScoreRecyclerview.adapter = FootballLeagueAdapterxt())
            }
            override fun onFailure(call: Call<Score>, t: Throwable) {
                Log.d("Failure", t.localizedMessage!!)
            }
        })
    }*/
}
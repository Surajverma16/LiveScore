package com.example.scorecheckingapp.fragments.Football

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.API.matchApi.Score
import com.example.scorecheckingapp.adapter.FootballLeagueAdapter
import com.example.scorecheckingapp.databinding.FragmentFootballTodayScoreBinding
import com.example.scorecheckingapp.interfaceApi.ApiInterface
import com.example.scorecheckingapp.interfaceApi.BASE_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.*

class FootballTodayScoreFragment : Fragment() {

    lateinit var binding: FragmentFootballTodayScoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getApiData()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFootballTodayScoreBinding.inflate(layoutInflater, container, false)

        return binding.root
    }


    fun getApiData() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)


        val retrofitData = retrofit.getScore(
            SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(Date()),
            "football",
            TimeZone.getTimeZone("GMT+05:30").toString(),
            "0556ba5f2bmshb44144c24b34dd9p19186cjsne46d41378f92",
            "livescore6.p.rapidapi.com"
        )
        retrofitData.enqueue(object : Callback<Score> {
            override fun onResponse(call: Call<Score>, response: Response<Score>) {
                val responseBody = response.body()!!
                binding.progressBar.visibility = View.GONE
                binding.footballScoreRecyclerView.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                binding.footballScoreRecyclerView.adapter =
                    FootballLeagueAdapter(responseBody.Stages, requireContext())
            }

            override fun onFailure(call: Call<Score>, t: Throwable) {
                Log.d("Failure", t.localizedMessage!!)
            }
        })
    }

}


/*
    displayArray,
    requireContext(),
    object : FootballScoreAdapter.onSingleItemClick{
        override fun clicked(footballScoreDataClass: FootballScoreDataClass) {
            (context as MainActivity).supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, FootballMatchDetailsFragment(footballScoreDataClass))
                addToBackStack(null)
                commit()
            }
        }

    }*/
//        )


/*
        val displayArray = ArrayList<FootballScoreDataClass>()
        for (i in 0..10) {
            displayArray.add(
                FootballScoreDataClass(
                    "Live",
                    R.drawable.fc_barcelona,
                    R.drawable.real_madrid,
                    "FC Barcelona",
                    "Real Madrid",
                    5,
                    2
                )
            )
            displayArray.add(
                FootballScoreDataClass(
                    "FT",
                    R.drawable.arsenal,
                    R.drawable.manchester_city,
                    "Arsenal",
                    "Manchester City",
                    4,
                    3
                )
            )
            displayArray.add(
                FootballScoreDataClass(
                    "Live",
                    R.drawable.villarreal,
                    R.drawable.juventus,
                    "Villarreal",
                    "Juventus",
                    0,
                    1
                )
            )
            displayArray.add(
                FootballScoreDataClass(
                    "Live",
                    R.drawable.napoli,
                    R.drawable.olympique_lyonnais,
                    "Napoli",
                    "Lyon",
                    3,
                    2
                )
            )
            displayArray.add(
                FootballScoreDataClass(
                    "Live",
                    R.drawable.paris_saint_germain,
                    R.drawable.bayern_munchen,
                    "Paris Saint German",
                    "Bayern Munich",
                    5,
                    1
                )
            )
            displayArray.add(
                FootballScoreDataClass(
                    "Live",
                    R.drawable.roman,
                    R.drawable.napoli,
                    "Roma",
                    "Napoli",
                    3,
                    5
                )
            )
            displayArray.add(
                FootballScoreDataClass(
                    "Live",
                    R.drawable.liverpool,
                    R.drawable.manchester_united,
                    "Liverpool",
                    "Manchester United",
                    5,
                    1
                )
            )
        }*/
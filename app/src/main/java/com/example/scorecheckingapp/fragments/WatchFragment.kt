package com.example.scorecheckingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.scorecheckingapp.activity.MainActivity
import com.example.scorecheckingapp.databinding.FragmentWatchBinding


class WatchFragment : Fragment() {

    lateinit var binding: FragmentWatchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWatchBinding.inflate(layoutInflater, container, false)
//        getApiData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).binding.bottomNavMenu.menu.getItem(3).isChecked = true
        (activity as MainActivity).setTitle("Watch")

    }

    /*fun getApiData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://free-football-soccer-videos.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(watchInterface::class.java)

        val retrofitData = retrofit.getVideo(
            "https://free-football-soccer-videos.p.rapidapi.com/",
            "0556ba5f2bmshb44144c24b34dd9p19186cjsne46d41378f92",
            "free-football-soccer-videos.p.rapidapi.com"
        )

        retrofitData.enqueue(object : Callback<List<watchItem>> {
            override fun onResponse(
                call: Call<List<watchItem>>,
                response: Response<List<watchItem>>,
            ) {
                val responseBody = response.body()!!
                binding.watchRecyclerView.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                binding.watchRecyclerView.adapter = WatchAdapter(responseBody)
//                Log.d("Response" , responseBody.toString())
            }

            override fun onFailure(call: Call<List<watchItem>>, t: Throwable) {
                Log.d("Failure", t.localizedMessage!!)
            }
        })
    }*/

}
package com.example.scorecheckingapp.fragments.News

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.API.NewsApi.*
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.activity.MainActivity
import com.example.scorecheckingapp.adapter.NewsAdapter
import com.example.scorecheckingapp.adapter.NewsCategoriesAdapter
import com.example.scorecheckingapp.adapter.NewsSpecificSportsAdapter
import com.example.scorecheckingapp.databinding.FragmentNewsBinding
import com.example.scorecheckingapp.databinding.FragmentNewsSpecificSportsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsSpecificSportsFragment(val category: Category) : Fragment() {

    lateinit var binding: FragmentNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(layoutInflater,container,false)
        getNewsData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun getNewsData() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://livescore6.p.rapidapi.com/news/v2/")
            .build()
            .create(NewsCategoriesInterface::class.java)

        val retrofitNews = retrofit.getCategories(
            category.id,
            "3eec2cda7cmsh0b270ac72d231f3p14a1eajsnb49154bb7c2e",
            "livescore6.p.rapidapi.com"
        )

        retrofitNews?.enqueue(object : Callback<Categories> {
            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                val responseBody = response.body()!!
                binding.categoriesNews.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                binding.categoriesNews.adapter =  NewsCategoriesAdapter(categoriesIds!!, requireContext(),
                    object : NewsCategoriesAdapter.onClickedCategories {
                        override fun clickedCategories(category: Category) {
                            (context as MainActivity).supportFragmentManager.beginTransaction().apply {
                                replace(R.id.fragment_container, NewsSpecificSportsFragment(category))
                                addToBackStack("News")
                                commit()
                            }
                        }

                    })

            }

            override fun onFailure(call: Call<Categories>, t: Throwable) {
                Log.d("Failure", t.localizedMessage!!.toString())
            }
        })


    }
}
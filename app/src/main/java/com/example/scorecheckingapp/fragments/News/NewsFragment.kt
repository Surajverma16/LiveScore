package com.example.scorecheckingapp.fragments.News

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.API.NewsApi.Category
import com.example.scorecheckingapp.API.NewsApi.News
import com.example.scorecheckingapp.API.NewsApi.NewsInterface
import com.example.scorecheckingapp.API.NewsApi.TopStory
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.activity.MainActivity
import com.example.scorecheckingapp.adapter.NewsAdapter
import com.example.scorecheckingapp.adapter.NewsCategoriesAdapter
import com.example.scorecheckingapp.adapter.NewsHomePageAdapter
import com.example.scorecheckingapp.databinding.FragmentNewsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsFragment() : Fragment() {

    lateinit var binding: FragmentNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNewsBinding.inflate(layoutInflater, container, false)
        getNewsData()
//        getHomePage()


        return binding.root
    }

 /*   private fun getHomePage() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("")
    }
*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).binding.bottomNavMenu.menu.getItem(2).isChecked = true

    }


    private fun getNewsData() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://livescore6.p.rapidapi.com/news/v2/")
            .build()
            .create(NewsInterface::class.java)

        val retrofitNews = retrofit.getNews(
            "b72713c116msh3868c671703c21dp15679bjsn6f00e94a7fc0",
            "livescore6.p.rapidapi.com"
        )

        retrofitNews?.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val responseBody = response.body()!!
                Log.d("Response", responseBody.toString())
                binding.newsRecyclerView.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                binding.newsRecyclerView.adapter = NewsAdapter(responseBody.topStories, requireContext())

                binding.sportsNameNewsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                binding.sportsNameNewsRecyclerView.adapter = NewsHomePageAdapter( responseBody.homepageArticles,requireContext())

                binding.categoriesNews.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                binding.categoriesNews.adapter = NewsCategoriesAdapter(responseBody.categories, requireContext())

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Failure", t.localizedMessage.toString())
            }
        })

    }


}
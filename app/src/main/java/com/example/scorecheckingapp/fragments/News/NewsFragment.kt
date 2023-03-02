package com.example.scorecheckingapp.fragments.News

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scorecheckingapp.API.NewsApi.*
import com.example.scorecheckingapp.R
import com.example.scorecheckingapp.activity.MainActivity
import com.example.scorecheckingapp.adapter.NewsAdapter
import com.example.scorecheckingapp.adapter.NewsCategoriesAdapter
import com.example.scorecheckingapp.adapter.NewsHomePageAdapter
import com.example.scorecheckingapp.adapter.NewsSpecificSportsAdapter
import com.example.scorecheckingapp.databinding.FragmentNewsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var categoriesIds: List<Category>? = null

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
//        getHomePageArticle()



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).binding.bottomNavMenu.menu.getItem(2).isChecked = true
        (activity as MainActivity).setTitle("News")

    }


    private fun getNewsData() {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://livescore6.p.rapidapi.com/news/v2/")
            .build()
            .create(NewsInterface::class.java)

        val retrofitNews = retrofit.getNews(
            "0556ba5f2bmshb44144c24b34dd9p19186cjsne46d41378f92",
            "livescore6.p.rapidapi.com"
        )

        retrofitNews?.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val responseBody = response.body()!!
                Log.d("Response", responseBody.toString())
                binding.newsRecyclerView.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                binding.newsRecyclerView.adapter =
                    NewsAdapter(responseBody.topStories, requireContext(),object : NewsAdapter.onClickingNews {
                        override fun clickedNews(topStory: TopStory) {
                            (context as MainActivity).supportFragmentManager.beginTransaction().apply {
                                replace(R.id.fragment_container, NewsTopStoryDetails(topStory),"News")
                                addToBackStack("News")
                                commit()
                            }
                        }
                    })

                binding.homePageRecyclerView.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                binding.homePageRecyclerView.adapter =
                    NewsHomePageAdapter(responseBody.homepageArticles, requireContext())

                binding.categoriesNews.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

                categoriesIds = responseBody.categories

                binding.categoriesNews.adapter =
                    NewsCategoriesAdapter(responseBody.categories, requireContext(),
                        object : NewsCategoriesAdapter.onClickedCategories {
                            override fun clickedCategories(category: Category) {
                                val retrofit1 = Retrofit.Builder()
                                    .addConverterFactory(GsonConverterFactory.create())
                                    .baseUrl("https://livescore6.p.rapidapi.com/news/v2/")
                                    .build()
                                    .create(NewsCategoriesInterface::class.java)

                                val retrofitNews1 = retrofit1.getCategories(
                                    category.id,
                                    "3eec2cda7cmsh0b270ac72d231f3p14a1eajsnb49154bb7c2e",
                                    "livescore6.p.rapidapi.com"
                                )

                                retrofitNews1?.enqueue(object : Callback<Categories> {
                                    override fun onResponse(
                                        call: Call<Categories>,
                                        response: Response<Categories>,
                                    ) {
                                        val responseBody1 = response.body()!!
                                        binding.newsRecyclerView.layoutManager =
                                            LinearLayoutManager(
                                                requireContext(),
                                                LinearLayoutManager.VERTICAL,
                                                false
                                            )
                                        binding.newsRecyclerView.adapter =
                                            NewsSpecificSportsAdapter(
                                                requireContext(),
                                                responseBody1.data,
                                                object :
                                                    NewsSpecificSportsAdapter.setOnClickingItem {
                                                    override fun onClicked(data: Data) {
                                                        (context as MainActivity).supportFragmentManager.beginTransaction()
                                                            .apply {
                                                                replace(
                                                                    R.id.fragment_container,
                                                                    NewsDetailsFragment(data)
                                                                )
                                                                addToBackStack(null)
                                                                commit()
                                                            }
                                                    }
                                                })
                                        binding.homePageRecyclerView.layoutManager = null
                                        binding.homePageRecyclerView.adapter = null
                                    }

                                    override fun onFailure(call: Call<Categories>, t: Throwable) {
                                        Log.d("Failure", t.localizedMessage!!.toString())
                                    }
                                })

                            }
                        }

                    )
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Failure", t.localizedMessage!!.toString())
            }
        })
    }


    fun getHomePageArticle(){
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://livescore6.p.rapidapi.com/news/v2/")
            .build()
            .create(NewsInterface::class.java)

        val retrofitNews = retrofit.getNews(
            "0556ba5f2bmshb44144c24b34dd9p19186cjsne46d41378f92",
            "livescore6.p.rapidapi.com"
        )

        retrofitNews?.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val responseBody = response.body()!!

            }


            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("Failure", t.localizedMessage!!.toString())
            }


        })
    }
}
package com.example.scorecheckingapp.fragments.News

import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.scorecheckingapp.API.NewsApi.Article
import com.example.scorecheckingapp.API.NewsApi.NewsDetailsInterface
import com.example.scorecheckingapp.API.NewsApi.details
import com.example.scorecheckingapp.databinding.ListNewsDetailsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.StringWriter

class NewsHomePageDetails(val homepageArticle: Article) : Fragment() {

    lateinit var binding: ListNewsDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListNewsDetailsBinding.inflate(layoutInflater,container,false)
        getNewsDetails()
        return binding.root
    }

    fun getNewsDetails(){
        binding.progressBar.visibility = View.VISIBLE
        val retrofit = Retrofit.Builder()
            .baseUrl("https://livescore6.p.rapidapi.com/news/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsDetailsInterface::class.java)

        val retrofitNews = retrofit.getNewsDetails(homepageArticle.id,"3eec2cda7cmsh0b270ac72d231f3p14a1eajsnb49154bb7c2e",
            "livescore6.p.rapidapi.com")

        retrofitNews.enqueue(object : Callback<details?> {
            override fun onResponse(call: Call<details?>, response: Response<details?>) {
                val responseBody = response.body()
                binding.progressBar.visibility = View.GONE
                binding.newsDetailsHeaderText.text = responseBody!!.adsTargeting.newsArticleTitle
                binding.newsDetailsImageDescriptionText.text = responseBody.article.mainMedia.gallery.alt
                Glide.with(context!!)
                    .load(responseBody.article.mainMedia.gallery.url)
                    .into(binding.newsDetailsImage)
                val sw = StringWriter()
                for (respnsonse in responseBody.article.body.indices){
                    sw.append(responseBody.article.body[respnsonse].data.content+"\n\n")
                    Log.d("rpsdcnmsd",responseBody.article.body[respnsonse].data.toString())
                }
                binding.run { newsDetailsDescriptionText.setText(Html.fromHtml(sw.toString())) }



            }

            override fun onFailure(call: Call<details?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
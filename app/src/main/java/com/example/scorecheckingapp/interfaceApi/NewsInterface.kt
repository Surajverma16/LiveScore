package com.example.scorecheckingapp.interfaceApi

import com.example.scorecheckingapp.API.NewsApi.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface NewsInterface {

    @GET("list")
    fun getNews(
        @Header("X-RapidAPI-Key") apiKey : String,
        @Header("X-RapidAPI-Host") apiHost :String): Call<News>?
}
package com.example.scorecheckingapp.API.NewsApi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsInterface {

    @GET("list")
    fun getNews(
        @Header("X-RapidAPI-Key") apiKey : String,
        @Header("X-RapidAPI-Host") apiHost :String): Call<News>?
}
package com.example.scorecheckingapp.API

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


const val BASE_URL = "https://livescore6.p.rapidapi.com/matches/v2/"

interface ApiInterface {
    @GET("list-by-date")
    fun getScore(
        @Query("Date") date: String,
        @Query("Category") category: String,
        @Query("Timezone") timezone : String,
        @Header("X-RapidAPI-Key") apiKey : String,
        @Header("X-RapidAPI-Host") apiHost : String
    ):Call<Score>
}
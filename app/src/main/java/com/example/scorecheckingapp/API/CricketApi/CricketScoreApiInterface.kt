package com.example.scorecheckingapp.API.CricketApi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CricketScoreApiInterface {
    @GET("list-by-date")
    fun getScore(
        @Query("Category") category: String,
        @Query("Date")date : String,
        @Query("Timezone") timezone : String,
        @Header("X-RapidAPI-Key") apiKey : String,
        @Header("X-RapidAPI-Host") apiHost : String
    ):Call<cricket>
}
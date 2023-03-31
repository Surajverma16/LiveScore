package com.example.scorecheckingapp.interfaceApi

import com.example.scorecheckingapp.API.matchApi.Score
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LeagueDetailsInterface {

    @GET("list-by-league")
    fun getLeagueDetails(
        @Header("X-RapidAPI-Key") apiKey : String,
        @Header("X-RapidAPI-Host") apiHost : String,
        @Query("Category") category : String,
        @Query("Ccd") ccd : String,
        @Query("Timezone") timeZone : String
    ): Call<Score>
}
package com.example.scorecheckingapp.API.favouriteApi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface FavouriteApiInterface {

    @GET("get-scoreboard")
    fun getData(
        @Header("X-RapidAPI-Key") apiKey : String,
        @Header("X-RapidAPI-Host") apiHost : String,
        @Query("Eid") eid : String,
        @Query("Category") category : String
    ):Call<favourite>
}
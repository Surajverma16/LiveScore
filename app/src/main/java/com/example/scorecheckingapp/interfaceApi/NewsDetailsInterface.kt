package com.example.scorecheckingapp.interfaceApi

import com.example.scorecheckingapp.API.NewsApi.details
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsDetailsInterface {

    @GET("detail")
    fun getNewsDetails(
        @Query("id") ID : String,
        @Header("X-RapidAPI-Key") apiKey : String,
        @Header("X-RapidAPI-Host") apiHost :String
    ): Call<details>
}
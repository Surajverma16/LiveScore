package com.example.scorecheckingapp.interfaceApi

import com.example.scorecheckingapp.API.NewsApi.Categories
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface NewsCategoriesInterface {

    @GET("list-by-sport")
    fun getCategories(
        @Query("category") Category : String,
        @Header("X-RapidAPI-Key") apiKey : String,
        @Header("X-RapidAPI-Host") apiHost :String): Call<Categories>?
}
package com.example.scorecheckingapp.API.NewsApi

import retrofit2.http.GET

interface NewsCategoriesInterface {

    @GET
    fun getCategories()
}
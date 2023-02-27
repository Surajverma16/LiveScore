package com.example.scorecheckingapp.API.NewsApi

data class NewsParams(
    val mediaCategory: String,
    val newsArticleUrl: String,
    val oddsWidgetIsPresent: Boolean
)
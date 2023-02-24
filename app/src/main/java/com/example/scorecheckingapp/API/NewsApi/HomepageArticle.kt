package com.example.scorecheckingapp.API.NewsApi

data class HomepageArticle(
    val articles: List<Article>,
    val category: CategoryX,
    val meta: Meta
)
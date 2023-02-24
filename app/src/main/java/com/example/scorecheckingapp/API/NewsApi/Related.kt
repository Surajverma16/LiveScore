package com.example.scorecheckingapp.API.NewsApi

data class Related(
    val relatedArticles: List<Any>,
    val tags: List<Tag>
)
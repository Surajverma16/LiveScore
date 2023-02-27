package com.example.scorecheckingapp.API.NewsApi

data class RelatedArticle(
    val categoryLabel: String,
    val categoryUrl: String,
    val id: String,
    val isAdultContent: Boolean,
    val mainMedia: MainMediaXXXXX,
    val publishedAt: String,
    val publishedRegions: List<Any>,
    val related: Any,
    val shortTitle: Any,
    val title: String,
    val type: Any,
    val updatedAt: UpdatedAtXX,
    val url: String
)
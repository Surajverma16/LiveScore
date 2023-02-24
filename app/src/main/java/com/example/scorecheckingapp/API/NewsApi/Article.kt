package com.example.scorecheckingapp.API.NewsApi

data class Article(
    val categoryLabel: String,
    val categoryUrl: String,
    val id: String,
    val isAdultContent: Boolean,
    val mainMedia: MainMediaX,
    val publishedAt: String,
    val publishedRegions: List<Any>,
    val related: Related,
    val shortTitle: Any,
    val title: String,
    val type: String,
    val updatedAt: UpdatedAt,
    val url: String
)
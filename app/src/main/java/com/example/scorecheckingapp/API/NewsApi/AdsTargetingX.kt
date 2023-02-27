package com.example.scorecheckingapp.API.NewsApi

data class AdsTargetingX(
    val adUnitPathName: String,
    val category: String,
    val environment: String,
    val newsArticleCategory: String,
    val newsArticleId: String,
    val newsArticleLeague: String,
    val newsArticleSensitiveContent: Boolean,
    val newsArticleTags: String,
    val newsArticleTeam: String,
    val newsArticleTitle: String,
    val screen: String
)
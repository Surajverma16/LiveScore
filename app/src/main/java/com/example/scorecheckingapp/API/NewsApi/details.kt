package com.example.scorecheckingapp.API.NewsApi

data class details(
    val activeSport: String,
    val adsTargeting: AdsTargetingX,
    val ampWidgetsData: Any,
    val article: ArticleX,
    val articleId: String,
    val categories: List<CategoryXXXX>,
    val categoryName: String,
    val categoryTitle: String,
    val generated: String,
    val isAmpEnabled: Any,
    val isArticle: Boolean,
    val layoutContext: LayoutContextX,
    val segmentTracking: SegmentTrackingX
)
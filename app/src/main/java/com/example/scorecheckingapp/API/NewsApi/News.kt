package com.example.scorecheckingapp.API.NewsApi

data class News(
    val adsTargeting: AdsTargeting,
    val categories: List<Category>,
    val featuredArticles: List<FeaturedArticle>,
    val homepageArticles: List<HomepageArticle>,
    val isNetworkError: Boolean,
    val layoutContext: LayoutContext,
    val segmentTracking: SegmentTracking,
    val topStories: List<TopStory>
)
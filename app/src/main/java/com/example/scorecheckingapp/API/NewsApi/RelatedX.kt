package com.example.scorecheckingapp.API.NewsApi

data class RelatedX(
    val relatedArticles: List<RelatedArticle>,
    val tags: List<TagX>
)
package com.example.scorecheckingapp.API.NewsApi

data class CategoryXXXX(
    val active: Boolean,
    val createdAt: String,
    val createdBy: CreatedByXXXXX,
    val description: String,
    val id: String,
    val initialTitle: String,
    val listPosition: Int,
    val media: List<MediaX>,
    val parentId: Any,
    val pathname: String,
    val seo: SeoXXXXXXXX,
    val subs: List<Any>,
    val title: String,
    val updatedAt: String
)
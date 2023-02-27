package com.example.scorecheckingapp.API.NewsApi

data class CategoryXXX(
    val active: Boolean,
    val createdAt: String,
    val createdBy: CreatedByXXX,
    val description: Any,
    val id: String,
    val initialTitle: String,
    val listPosition: Int,
    val media: List<Any>,
    val parentId: Any,
    val pathname: String,
    val seo: SeoXXXXXX,
    val subs: List<Any>,
    val title: String,
    val updatedAt: String
)
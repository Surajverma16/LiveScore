package com.example.scorecheckingapp.API.NewsApi

data class CategoryXX(
    val active: Boolean,
    val created_at: String,
    val created_by: CreatedByXXXXX,
    val description: Any,
    val entity_type: String,
    val generic: Any,
    val id: String,
    val main_media: List<Any>,
    val parent_id: Any,
    val seo: SeoXXXX,
    val subs: List<Any>,
    val title: String,
    val updated_at: String,
    val urls: UrlsXX,
    val weight: Int
)
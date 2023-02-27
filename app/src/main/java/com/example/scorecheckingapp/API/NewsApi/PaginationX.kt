package com.example.scorecheckingapp.API.NewsApi

data class PaginationX(
    val count: Int,
    val current_page: Int,
    val links: LinksX,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)
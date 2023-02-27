package com.example.scorecheckingapp.API.NewsApi

data class PublishedBy(
    val contactUrl: String,
    val logo: String,
    val logoSize: LogoSize,
    val name: String,
    val telephone: String,
    val websiteUrl: String
)
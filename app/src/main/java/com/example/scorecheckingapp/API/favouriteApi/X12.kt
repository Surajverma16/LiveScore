package com.example.scorecheckingapp.API.favouriteApi

data class X12(
    val allowedCountries: List<String>,
    val eventId: String,
    val provider: String,
    val type: String
)
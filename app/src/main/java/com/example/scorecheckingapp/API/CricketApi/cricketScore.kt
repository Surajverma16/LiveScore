package com.example.scorecheckingapp.API.CricketApi

data class cricketScore(
    val appIndex: AppIndex,
    val filters: Filters,
    val responseLastUpdated: String,
    val typeMatches: List<TypeMatche>
)
package com.example.scorecheckingapp.API.CricketApi

data class SeriesAdWrapper(
    val matches: List<Matche>,
    val seriesId: Int,
    val seriesName: String
)
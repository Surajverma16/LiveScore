package com.example.scorecheckingapp.API.CricketApi

data class VenueInfo(
    val city: String,
    val ground: String,
    val id: Int,
    val latitude: String,
    val longitude: String,
    val timezone: String
)
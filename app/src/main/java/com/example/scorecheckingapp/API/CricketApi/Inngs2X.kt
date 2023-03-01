package com.example.scorecheckingapp.API.CricketApi

data class Inngs2X(
    val inningsId: Int,
    val isFollowOn: Boolean,
    val overs: Double,
    val runs: Int,
    val wickets: Int
)
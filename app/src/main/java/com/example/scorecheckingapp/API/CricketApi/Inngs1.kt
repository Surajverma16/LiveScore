package com.example.scorecheckingapp.API.CricketApi

data class Inngs1(
    val inningsId: Int,
    val isDeclared: Boolean,
    val overs: Double,
    val runs: Int,
    val wickets: Int
)
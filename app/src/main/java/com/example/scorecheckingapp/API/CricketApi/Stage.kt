package com.example.scorecheckingapp.API.CricketApi

data class Stage(
    val Ccd: String,
    val Cnm: String,
    val Csnm: String,
    val Events: ArrayList<Event>,
    val Scd: String,
    val Scu: Int,
    val Sid: String,
    val Snm: String
)
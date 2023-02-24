package com.example.scorecheckingapp.API.matchApi

import com.example.scorecheckingapp.API.matchApi.Event

data class Stage(
    val Ccd: String,
    val Cnm: String,
    val CompD: String,
    val CompId: String,
    val CompN: String,
    val CompST: String,
    val Csnm: String,
    val Events: ArrayList<Event>,
    val Scd: String,
    val Scu: Int,
    val Sid: String,
    val Snm: String
)
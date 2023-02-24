package com.example.scorecheckingapp.API.matchApi

data class Event(
    val EO: Int,
    val Ecov: Int,
    val Eid: String,
    val Epr: Int,
    val Eps: String,
    val ErnInf: String,
    val Esd: Long,
    val Esid: Int,
    val Et: Int,
    val Ewt: Int,
    val Pid: Int,
    val Pids: Pids,
    val Spid: Int,
    val T1: ArrayList<Team>,
    val T2: ArrayList<Team>,
    val Tr1: String,
    val Tr1OR: String,
    val Tr2: String,
    val Tr2OR: String,
    val Trh1: String,
    val Trh2: String
)
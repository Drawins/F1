package com.example.f1

data class Race(
    val season: String,
    val round: String,
    val raceName: String,
    val date: String,
    val time: String,
    val circuit: String,
    val information: String
)

data class RaceTable(
    val RaceTable: RaceDetails
)

data class RaceDetails(
    val season: String,
    val Rounds: List<Race>
)

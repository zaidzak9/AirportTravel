package com.zaid.airporttravel.model

data class PlacesApiResponse(
    val candidates: List<Candidate>,
    val status: String
)
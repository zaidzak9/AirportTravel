package com.zaid.airporttravel.model

data class Candidate(
    val formatted_address: String,
    val name: String,
    val photos: List<Photo>,
    val rating: Double
)
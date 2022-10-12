package com.lucassalbu.catalogodefilmeshilt.models

data class MovieDetailModel(
    val backdrop_path: String,
    val genres: List<Genre>,
    val id: Int,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double
)
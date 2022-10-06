package com.lucassalbu.catalogodefilmeshilt.models

data class PopularMoviesModel(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
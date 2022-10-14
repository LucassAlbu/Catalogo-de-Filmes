package com.lucassalbu.catalogodefilmeshilt.models

data class TopRatedModel(
    val page: Int,
    val topResults: List<TopResult>,
    val total_pages: Int,
    val total_results: Int
)
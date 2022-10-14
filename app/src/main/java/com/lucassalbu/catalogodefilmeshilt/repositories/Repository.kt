package com.lucassalbu.catalogodefilmeshilt.repositories

import com.lucassalbu.catalogodefilmeshilt.models.MovieDetailModel
import com.lucassalbu.catalogodefilmeshilt.models.PopularMoviesModel
import com.lucassalbu.catalogodefilmeshilt.models.TopRatedModel
import retrofit2.Response

interface Repository {
    suspend fun getPopularMovie(): Response<PopularMoviesModel>
    suspend fun getMovieDetail(movieID: Int): Response<MovieDetailModel>
    suspend fun getTopRated(): Response<TopRatedModel>
}
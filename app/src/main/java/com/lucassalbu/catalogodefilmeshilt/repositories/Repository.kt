package com.lucassalbu.catalogodefilmeshilt.repositories

import com.lucassalbu.catalogodefilmeshilt.models.MovieDetailModel
import com.lucassalbu.catalogodefilmeshilt.models.MoviesModel
import retrofit2.Response

interface Repository {
    suspend fun getPopularMovie(): Response<MoviesModel>
    suspend fun getMovieDetail(movieID: Int): Response<MovieDetailModel>
    suspend fun getTopRated(): Response<MoviesModel>
}
package com.lucassalbu.catalogodefilmeshilt.serviceApi

import com.lucassalbu.catalogodefilmeshilt.models.MovieDetailModel
import com.lucassalbu.catalogodefilmeshilt.models.PopularMoviesModel
import com.lucassalbu.catalogodefilmeshilt.utils.Contants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/3/movie/popular$API_KEY&language=pt-BR")
    suspend fun getPopularMovies(): Response<PopularMoviesModel>

    @GET("/3/movie/{movie_id}$API_KEY&language=pt-BR")
    suspend fun getMoviesDetails(
        @Path("movie_id") movieID: Int
    ): Response<MovieDetailModel>
}



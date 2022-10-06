package com.lucassalbu.catalogodefilmeshilt.serviceApi

import com.lucassalbu.catalogodefilmeshilt.models.PopularMoviesModel
import com.lucassalbu.catalogodefilmeshilt.utils.Contants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/movie/popular$API_KEY")
    suspend fun getPopularMovies(): Response<PopularMoviesModel>
}
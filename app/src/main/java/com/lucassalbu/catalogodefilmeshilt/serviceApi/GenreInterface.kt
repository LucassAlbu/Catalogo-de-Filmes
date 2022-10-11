package com.lucassalbu.catalogodefilmeshilt.serviceApi

import com.lucassalbu.catalogodefilmeshilt.models.IdGenreMovie
import com.lucassalbu.catalogodefilmeshilt.utils.Contants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET

interface GenreInterface {
    @GET("/3/genre/movie/list$API_KEY")
    suspend fun getGenre (): Response<IdGenreMovie>
}
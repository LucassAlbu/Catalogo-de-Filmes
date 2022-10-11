package com.lucassalbu.catalogodefilmeshilt.repositories

import com.lucassalbu.catalogodefilmeshilt.models.PopularMoviesModel
import retrofit2.Response

interface Repository {
    suspend fun getPopularMovie(): Response<PopularMoviesModel>
}
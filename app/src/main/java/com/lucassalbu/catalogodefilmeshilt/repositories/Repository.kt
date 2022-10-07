package com.lucassalbu.catalogodefilmeshilt.repositories

import com.lucassalbu.catalogodefilmeshilt.models.PopularMoviesModel
import com.lucassalbu.catalogodefilmeshilt.models.Result
import retrofit2.Response

interface Repository {
    suspend fun getPopularMovie(): Response<PopularMoviesModel>
}
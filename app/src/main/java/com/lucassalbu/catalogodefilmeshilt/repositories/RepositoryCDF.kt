package com.lucassalbu.catalogodefilmeshilt.repositories

import com.lucassalbu.catalogodefilmeshilt.models.MovieDetailModel
import com.lucassalbu.catalogodefilmeshilt.models.PopularMoviesModel
import com.lucassalbu.catalogodefilmeshilt.models.TopRatedModel
import com.lucassalbu.catalogodefilmeshilt.serviceApi.ApiInterface
import retrofit2.Response
import javax.inject.Inject

class RepositoryCDF @Inject constructor(
    // private val userDataStore: DataStore<Preferences>,
    private val apiInterface: ApiInterface,
) : Repository {
    override suspend fun getPopularMovie(): Response<PopularMoviesModel> {
        return apiInterface.getPopularMovies()
    }

    override suspend fun getMovieDetail(movieID: Int): Response<MovieDetailModel> {
        return apiInterface.getMoviesDetails(movieID)
    }

    override suspend fun getTopRated(): Response<TopRatedModel> {
        return apiInterface.getTopRated()
    }


}
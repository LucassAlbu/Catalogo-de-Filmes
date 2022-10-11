package com.lucassalbu.catalogodefilmeshilt.repositories

import com.lucassalbu.catalogodefilmeshilt.models.IdGenreMovie
import com.lucassalbu.catalogodefilmeshilt.models.PopularMoviesModel
import com.lucassalbu.catalogodefilmeshilt.serviceApi.GenreInterface
import com.lucassalbu.catalogodefilmeshilt.serviceApi.PopularMovieInterface
import retrofit2.Response
import javax.inject.Inject

class RepositoryCDF @Inject constructor(
    // private val userDataStore: DataStore<Preferences>,
    private val popularMovieInterface: PopularMovieInterface,
    private val genreInterface : GenreInterface
) : Repository {
    override suspend fun getPopularMovie(): Response<PopularMoviesModel> {
        return popularMovieInterface.getPopularMovies()
    }

    override suspend fun getGenteMovie(): Response<IdGenreMovie> {
        return genreInterface.getGenre()
    }


}
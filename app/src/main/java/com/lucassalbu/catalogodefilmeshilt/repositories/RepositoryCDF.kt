package com.lucassalbu.catalogodefilmeshilt.repositories

import androidx.datastore.core.DataStore
import com.lucassalbu.catalogodefilmeshilt.models.PopularMoviesModel
import com.lucassalbu.catalogodefilmeshilt.models.Result
import com.lucassalbu.catalogodefilmeshilt.serviceApi.ApiInterface
import retrofit2.Response
import java.util.prefs.Preferences
import javax.inject.Inject

class RepositoryCDF @Inject constructor(
    // private val userDataStore: DataStore<Preferences>,
    private val apiInterface: ApiInterface
) : Repository {
    override suspend fun getPopularMovie(): Response<PopularMoviesModel> {
        return apiInterface.getPopularMovies()
    }


}
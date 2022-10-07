package com.lucassalbu.catalogodefilmeshilt.repositories

import androidx.datastore.core.DataStore
import com.lucassalbu.catalogodefilmeshilt.serviceApi.ApiInterface
import java.util.prefs.Preferences
import javax.inject.Inject

class RepositoryCDF @Inject constructor(
   // private val userDataStore: DataStore<Preferences>,
    private val apiInterface: ApiInterface
) : Repository {



}
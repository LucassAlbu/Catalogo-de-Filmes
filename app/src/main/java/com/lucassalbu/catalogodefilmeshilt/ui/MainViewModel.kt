package com.lucassalbu.catalogodefilmeshilt.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucassalbu.catalogodefilmeshilt.models.PopularMoviesModel
import com.lucassalbu.catalogodefilmeshilt.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var _popularMovie = MutableLiveData<PopularMoviesModel>()
    val popularMovie: LiveData<PopularMoviesModel> = _popularMovie

    fun getPopularMovie() {
        viewModelScope.launch {
            val response = repository.getPopularMovie()
            _popularMovie.postValue(response.body())
        }
    }

}
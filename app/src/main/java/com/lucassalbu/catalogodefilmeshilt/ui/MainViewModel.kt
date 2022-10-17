package com.lucassalbu.catalogodefilmeshilt.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lucassalbu.catalogodefilmeshilt.models.MovieDetailModel
import com.lucassalbu.catalogodefilmeshilt.models.MoviesModel
import com.lucassalbu.catalogodefilmeshilt.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var _popularMovie = MutableLiveData<MoviesModel>()
    val popularMovie: LiveData<MoviesModel> = _popularMovie

    private var _movieDetailModel = MutableLiveData<MovieDetailModel>()
    val movieDetailModel: LiveData<MovieDetailModel> = _movieDetailModel

    private var _topMovie = MutableLiveData<MoviesModel>()
    val topMovie: LiveData<MoviesModel> = _topMovie

    fun getPopularMovie() {
        viewModelScope.launch {
            val response = repository.getPopularMovie()
            _popularMovie.postValue(response.body())
        }
    }
    fun getMovieDetail(movieID: Int){
        viewModelScope.launch {
            val response = repository.getMovieDetail(movieID)
            _movieDetailModel.postValue(response.body())
        }
    }

    fun getTopMovie(){
        viewModelScope.launch {
            val response = repository.getTopRated()
            _topMovie.postValue(response.body())

        }
    }

}
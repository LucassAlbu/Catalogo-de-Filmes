package com.lucassalbu.catalogodefilmeshilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucassalbu.catalogodefilmeshilt.databinding.ActivityMoviesBinding

import com.lucassalbu.catalogodefilmeshilt.models.Movie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : AppCompatActivity() {

    lateinit var popularmovieAdapter: MovieAdapter
    lateinit var topRatedAdapter : MovieAdapter

    private var _binding: ActivityMoviesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        getMovies()


    }

    private fun initRecyclerView() {
        binding.rvMovies.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        popularmovieAdapter = MovieAdapter(this)
        binding.rvMovies.adapter = popularmovieAdapter

        binding.rvTopMovies.layoutManager = LinearLayoutManager( this, RecyclerView.HORIZONTAL,false)
        topRatedAdapter = MovieAdapter(this)
        binding.rvTopMovies.adapter = topRatedAdapter
    }

    private fun getMovies() {
        viewModel.getPopularMovie()
        viewModel.popularMovie.observe(this) {
            popularmovieAdapter.setMovieList(it.movies as ArrayList<Movie>)
            popularmovieAdapter.notifyDataSetChanged()
        }
        viewModel.getTopMovie()
        viewModel.topMovie.observe(this){
            topRatedAdapter.setMovieList(it.movies as ArrayList<Movie>)
            topRatedAdapter.notifyDataSetChanged()

        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }


}
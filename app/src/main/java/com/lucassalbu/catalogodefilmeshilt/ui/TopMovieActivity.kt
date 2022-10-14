package com.lucassalbu.catalogodefilmeshilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lucassalbu.catalogodefilmeshilt.adapters.TopMovieAdapter
import com.lucassalbu.catalogodefilmeshilt.databinding.ActivityMoviesBinding
import com.lucassalbu.catalogodefilmeshilt.models.Movie
import com.lucassalbu.catalogodefilmeshilt.models.TopResult

class TopMovieActivity : AppCompatActivity() {

    lateinit var topMovieAdapter: PopularMovieAdapter

    private var _binding: ActivityMoviesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        getTopMovies()

    }

    private fun initRecyclerView() {
        binding.rvTopMovies.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        topMovieAdapter = PopularMovieAdapter(this)
        binding.rvMovies.adapter = topMovieAdapter
    }

    private fun getTopMovies(){
        viewModel.getTopMovie()
        viewModel.topMovie.observe(this){
            topMovieAdapter.setTopMovieList(it.topResults as ArrayList<TopResult>)
            topMovieAdapter.notifyDataSetChanged()
        }

    }


}
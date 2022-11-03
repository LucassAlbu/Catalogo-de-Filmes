package com.lucassalbu.catalogodefilmeshilt.ui

import android.app.Activity
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lucassalbu.catalogodefilmeshilt.R
import com.lucassalbu.catalogodefilmeshilt.databinding.ActivityMoviesDetailBinding
import com.lucassalbu.catalogodefilmeshilt.models.Movie
import com.lucassalbu.catalogodefilmeshilt.models.MovieDetailModel
import com.lucassalbu.catalogodefilmeshilt.utils.Contants
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MoviesDetailActivity : AppCompatActivity() {


    lateinit var similarMovieAdapter: MovieAdapter

    private var _binding: ActivityMoviesDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMoviesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val movieID = intent.getIntExtra("movieID", 0)

        if (movieID != null) {
            getMovieDetails(movieID)
            viewModel.movieDetailModel.observe(this) {
                bindingDetails(it)
            }
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = ""
            setDisplayHomeAsUpEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

        // initListeners()
        initRecyclerView()
        getSimilarMovies(movieID)


    }
    override fun onBackPressed() {

        val intent = Intent(applicationContext, MoviesDetailActivity::class.java)
        startActivity(intent)
        super.onBackPressed()
    }




    private fun initRecyclerView() {
        binding.rvSimilarMovies.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        similarMovieAdapter = MovieAdapter(this)
        binding.rvSimilarMovies.adapter = similarMovieAdapter
    }

    private fun getMovieDetails(movieID: Int) {
        viewModel.getMovieDetail(movieID)
        viewModel.movieDetailModel.observe(this) {
            this.bindingDetails(it)
        }
    }

    private fun getSimilarMovies(movieID: Int) {
        viewModel.getSimilarMovies(movieID)
        viewModel.similarMovie.observe(this) {
            similarMovieAdapter.setMovieList(it.movies as ArrayList<Movie>)
            similarMovieAdapter.notifyDataSetChanged()
        }
    }

    private fun bindingDetails(movieDetailModel: MovieDetailModel) {
        viewModel.movieDetailModel.observe(this) { movieDetail ->
            binding.tvMovieTitle.text = movieDetailModel.title.toString().trim()
            binding.tvYear.text = movieDetailModel.release_date.toString()
                .trim() //como converter o modelo americano pro br
            binding.tvSinopse.text = movieDetailModel.overview.toString().trim()


            Glide.with(binding.imPosterMovie)
                .load(Contants.POSTER_BASE_URL + movieDetailModel.backdrop_path)
                .error(R.drawable.ic_catalogo_de_filmes)
                .into(binding.imPosterMovie)

            Glide.with(binding.ivposter)
                .load(Contants.POSTER_BASE_URL + movieDetailModel.poster_path)
                .error(R.drawable.ic_catalogo_de_filmes)
                .into(binding.ivposter)

        }


    }

//    private fun initListeners() {
//        binding.ibBack.setOnClickListener {
//            val intent = Intent(this, MoviesActivity::class.java)
//            startActivity(intent)
//        }
//    }
}

//função no on create para pegar o Movieid e já setar oq vai ser oq
//getdetails
//setdata








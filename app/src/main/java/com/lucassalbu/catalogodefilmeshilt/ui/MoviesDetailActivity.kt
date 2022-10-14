package com.lucassalbu.catalogodefilmeshilt.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.lucassalbu.catalogodefilmeshilt.R
import com.lucassalbu.catalogodefilmeshilt.databinding.ActivityMoviesDetailBinding
import com.lucassalbu.catalogodefilmeshilt.models.MovieDetailModel
import com.lucassalbu.catalogodefilmeshilt.utils.Contants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesDetailActivity : AppCompatActivity() {



    private var _binding: ActivityMoviesDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMoviesDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieID = intent.getIntExtra("movieID",0)

        if (movieID != null) {
            getMovieDetails(movieID)
            viewModel.movieDetailModel.observe( this){
                bindingDetails(it)
            }
        }
        initListeners()

    }


    private fun getMovieDetails(movieID: Int) {
        viewModel.getMovieDetail(movieID)
        viewModel.movieDetailModel.observe(this) {
            this.bindingDetails(it)
        }
    }

    private fun bindingDetails(movieDetailModel: MovieDetailModel) {
        viewModel.movieDetailModel.observe(this) { movieDetail ->
            binding.tvMovieTitle.text = movieDetailModel.title.toString().trim()
            binding.tvYear.text = movieDetailModel.release_date.toString().trim() //como converter o modelo americano pro br
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
    private fun initListeners() {
        binding.ibBack.setOnClickListener {
            val intent = Intent(this, PopularMoviesActivity::class.java)
            startActivity(intent)
        }
    }
}

//função no on create para pegar o Movieid e já setar oq vai ser oq
//getdetails
//setdata







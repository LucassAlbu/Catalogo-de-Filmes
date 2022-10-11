package com.lucassalbu.catalogodefilmeshilt.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lucassalbu.catalogodefilmeshilt.R
import com.lucassalbu.catalogodefilmeshilt.databinding.RvMovieLayoutItemBinding
import com.lucassalbu.catalogodefilmeshilt.databinding.RvMoviesItemBinding
import com.lucassalbu.catalogodefilmeshilt.models.Movie
import com.lucassalbu.catalogodefilmeshilt.utils.Contants.Companion.POSTER_BASE_URL


class MovieAdapter(
    private val context: Context
) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movieList = ArrayList<Movie>()

    @JvmName("setMovieList1")
    fun setMovieList(data: ArrayList<Movie>) {
        this.movieList = data
    }

    class MovieViewHolder(private val binding: RvMoviesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindingMovieList(movie: Movie, context: Context) {
            binding.tvTitle.text = movie.original_title.toString().trim()
            binding.tvReleaseYear.text = movie.release_date.toString().format()
            binding.tvGenre.text = movie.genre_ids[0].toString().trim()

            Glide.with(binding.ivMoviePoster)
                .load(POSTER_BASE_URL + movie.poster_path)
                .error(R.drawable.ic_catalogo_de_filmes)
                .into(binding.ivMoviePoster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            RvMoviesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.bindingMovieList(movieList[position], context)

    }

    override fun getItemCount() = movieList.size


}
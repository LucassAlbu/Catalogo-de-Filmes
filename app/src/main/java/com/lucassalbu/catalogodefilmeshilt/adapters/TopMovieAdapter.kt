package com.lucassalbu.catalogodefilmeshilt.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lucassalbu.catalogodefilmeshilt.R
import com.lucassalbu.catalogodefilmeshilt.databinding.RvActivityTopMovieItemBinding
import com.lucassalbu.catalogodefilmeshilt.models.TopResult
import com.lucassalbu.catalogodefilmeshilt.ui.MoviesDetailActivity
import com.lucassalbu.catalogodefilmeshilt.utils.Contants
import kotlin.coroutines.jvm.internal.CompletedContinuation.context


class TopMovieAdapter(
    private val context: Context
) : RecyclerView.Adapter<TopMovieAdapter.TopMovieViewHolder>() {

    var topMovieList = ArrayList<TopResult>()

    @JvmName("setTopMovieList1")
    fun setTopMovieList(data: ArrayList<TopResult>) {
        this.topMovieList = data
    }

    class TopMovieViewHolder(private val binding: RvActivityTopMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindingTopMovieList(topResult: TopResult, context: Context) {

            Glide.with(binding.ivTopMoviePoster)
                .load(Contants.POSTER_BASE_URL + topResult.poster_path)
                .error(R.drawable.ic_catalogo_de_filmes)
                .into(binding.ivTopMoviePoster)

            binding.cdTopPrincipal.setOnClickListener {
                val intent = Intent(context, MoviesDetailActivity::class.java)
                intent.putExtra("movieID", topResult.id)
                context.startActivity(intent)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMovieViewHolder {
            val binding = RvActivityTopMovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return TopMovieViewHolder(binding)
        }

        override fun onBindViewHolder(holder: TopMovieViewHolder, position: Int) {

            holder.bindingTopMovieList(topMovieList[position], context)
        }

        override fun getItemCount() = topMovieList.size
    }
}
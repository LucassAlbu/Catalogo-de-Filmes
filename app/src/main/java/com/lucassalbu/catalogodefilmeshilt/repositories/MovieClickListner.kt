package com.lucassalbu.catalogodefilmeshilt.repositories

import com.lucassalbu.catalogodefilmeshilt.models.Movie


interface MovieClickListner {
    fun onClick(movie: Movie)
}
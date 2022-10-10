package com.lucassalbu.catalogodefilmeshilt.ui

import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationBarItemView
import com.lucassalbu.catalogodefilmeshilt.databinding.ActivityMainBinding
import com.lucassalbu.catalogodefilmeshilt.models.Result
import dagger.hilt.android.AndroidEntryPoint


class MovieAdapter(
    private val movieList: ArrayList<Result>
) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount() = movieList.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
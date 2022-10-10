package com.lucassalbu.catalogodefilmeshilt.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.lucassalbu.catalogodefilmeshilt.databinding.ActivityTesteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TesteActivity : AppCompatActivity() {

    private var _binding: ActivityTesteBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityTesteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()
        buildPopularMovies()
    }

    private fun initListeners() {
        binding.btVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun buildPopularMovies() {
        viewModel.getPopularMovie()

        viewModel.popularMovie.observe(this) { //popularMovie ->
//            binding.tvnomefilme.text = popularMovie.results[0].original_title
        }
    }
}
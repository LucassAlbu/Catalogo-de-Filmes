package com.lucassalbu.catalogodefilmeshilt.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.lucassalbu.catalogodefilmeshilt.R
import com.lucassalbu.catalogodefilmeshilt.databinding.ActivityMainBinding
import com.lucassalbu.catalogodefilmeshilt.databinding.ActivityMoviesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = getColor(R.color.status_bar)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}
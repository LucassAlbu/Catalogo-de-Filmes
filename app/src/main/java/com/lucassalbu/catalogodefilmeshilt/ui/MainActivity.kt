package com.lucassalbu.catalogodefilmeshilt.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.lucassalbu.catalogodefilmeshilt.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.statusBarColor = getColor(R.color.status_bar)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MoviesActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}
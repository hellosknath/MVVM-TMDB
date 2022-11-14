package com.blogspot.hellosrinath.mvvm_tmdb.presentation.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.blogspot.hellosrinath.mvvm_tmdb.R
import com.blogspot.hellosrinath.mvvm_tmdb.databinding.ActivityMovieBinding

class MovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_movie
        )
    }
}
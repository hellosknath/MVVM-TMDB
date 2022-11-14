package com.blogspot.hellosrinath.mvvm_tmdb.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.blogspot.hellosrinath.mvvm_tmdb.R
import com.blogspot.hellosrinath.mvvm_tmdb.databinding.ActivityHomeBinding
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.artist.ArtistActivity
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.movie.MovieActivity
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.tv.TvActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_home
        )
        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }
        binding.artistButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
        binding.tvshowButton.setOnClickListener {
            val intent = Intent(this, TvActivity::class.java)
            startActivity(intent)
        }
    }
}
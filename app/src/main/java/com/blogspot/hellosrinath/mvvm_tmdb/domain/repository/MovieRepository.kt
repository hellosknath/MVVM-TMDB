package com.blogspot.hellosrinath.mvvm_tmdb.domain.repository

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies():List<Movie>?
}
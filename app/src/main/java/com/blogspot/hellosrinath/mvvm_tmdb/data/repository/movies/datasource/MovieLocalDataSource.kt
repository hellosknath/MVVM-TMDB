package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDb(): List<Movie>
    suspend fun saveMoviesToDb(movies: List<Movie>)
    suspend fun clearAll()
}
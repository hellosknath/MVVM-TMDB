package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.Movie

interface MoviesCacheDataSource {
    suspend fun getMoviesFromCache(): List<Movie>
    suspend fun saveMovesToCache(movies: List<Movie>)
}
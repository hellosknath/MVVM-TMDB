package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}
package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasourceImpl

import com.blogspot.hellosrinath.mvvm_tmdb.data.api.TMDBService
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.MovieList
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}
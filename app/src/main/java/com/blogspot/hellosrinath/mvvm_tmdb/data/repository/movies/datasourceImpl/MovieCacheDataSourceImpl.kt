package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasourceImpl

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.Movie
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource.MoviesCacheDataSource

class MovieCacheDataSourceImpl : MoviesCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}
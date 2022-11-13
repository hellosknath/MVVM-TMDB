package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasourceImpl

import com.blogspot.hellosrinath.mvvm_tmdb.data.db.MovieDao
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.Movie
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImpl(private val movieDao: MovieDao) : MovieLocalDataSource {
    override suspend fun getMoviesFromDb(): List<Movie> = movieDao.getMovies()

    override suspend fun saveMoviesToDb(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}
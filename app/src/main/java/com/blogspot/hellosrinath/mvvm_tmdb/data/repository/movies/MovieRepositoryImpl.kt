package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies

import android.util.Log
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.Movie
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.MovieList
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource.MovieLocalDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource.MovieRemoteDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource.MoviesCacheDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.domain.repository.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val moviesCacheDataSource: MoviesCacheDataSource
) : MovieRepository {
    private val TAG = "MovieRepositoryImpl"

    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies: List<Movie> = getMoviesFromAPI()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDb(newListOfMovies)
        moviesCacheDataSource.saveMovesToCache(newListOfMovies)
        return newListOfMovies
    }

    suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response: Response<MovieList> = movieRemoteDataSource.getMovies()
            val body: MovieList? = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (ex: Exception) {
            Log.i(TAG, "getMoviesFromAPI: ${ex.message.toString()}")
        }

        return movieList
    }

    suspend fun getMoviesFromDb(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDb()
        } catch (e: Exception) {
            Log.i(TAG, "getMoviesFromDb: ${e.message.toString()}")
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesToDb(movieList)
        }
        return movieList
    }

    suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = moviesCacheDataSource.getMoviesFromCache()
        } catch (e: Exception) {
            Log.i(TAG, "getMoviesFromCache: ${e.message.toString()}")
        }
        if (movieList.size > 0) {
            return movieList
        } else {
            movieList = getMoviesFromDb()
            moviesCacheDataSource.saveMovesToCache(movieList)
        }
        return movieList
    }
}
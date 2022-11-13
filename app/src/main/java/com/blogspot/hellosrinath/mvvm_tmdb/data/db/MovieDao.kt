package com.blogspot.hellosrinath.mvvm_tmdb.data.db

import androidx.room.*
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.Movie

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE FROM popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM popular_movies")
    suspend fun getMovies(): List<Movie>
}
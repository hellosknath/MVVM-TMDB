package com.blogspot.hellosrinath.mvvm_tmdb.data.db

import androidx.room.*
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShow

@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShow: List<TvShow>)

    @Query("DELETE FROM popular_tvShows")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM popular_tvShows")
    suspend fun getTvShows(): List<TvShow>
}
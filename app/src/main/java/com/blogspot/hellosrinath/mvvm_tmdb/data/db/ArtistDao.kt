package com.blogspot.hellosrinath.mvvm_tmdb.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.Artist
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.movie.Movie

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artist: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtist()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtist(): List<Artist>
}
package com.blogspot.hellosrinath.mvvm_tmdb.data.db

import androidx.room.*
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.Artist

@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artist: List<Artist>)

    @Query("DELETE FROM popular_artists")
    suspend fun deleteAllArtist()

    @Query("SELECT * FROM popular_artists")
    suspend fun getArtist(): List<Artist>
}
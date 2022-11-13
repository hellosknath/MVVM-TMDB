package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.Artist

interface ArtistLocalDatasource {
    suspend fun getArtistFromLocalDb(): List<Artist>
    suspend fun saveArtistToLocalDb(artist: List<Artist>)
    suspend fun clearAll()
}
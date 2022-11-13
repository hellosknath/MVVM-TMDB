package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.Artist

interface ArtistCacheDatasource {
    suspend fun getArtistFromCache():List<Artist>
    suspend fun savesArtistToCache(artists: List<Artist>)
}
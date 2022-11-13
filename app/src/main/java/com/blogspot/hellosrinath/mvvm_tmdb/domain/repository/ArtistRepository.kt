package com.blogspot.hellosrinath.mvvm_tmdb.domain.repository

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtist(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}
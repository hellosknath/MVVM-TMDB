package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.Artist
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtist():Response<ArtistList>
}
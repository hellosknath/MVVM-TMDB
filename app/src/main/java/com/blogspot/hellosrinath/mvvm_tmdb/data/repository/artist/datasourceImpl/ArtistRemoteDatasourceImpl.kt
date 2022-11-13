package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasourceImpl

import com.blogspot.hellosrinath.mvvm_tmdb.data.api.TMDBService
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.Artist
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.ArtistList
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : ArtistRemoteDatasource {
    override suspend fun getArtist(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey)
}
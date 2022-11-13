package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.Artist
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.ArtistCacheDatasource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.ArtistLocalDatasource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.ArtistRemoteDatasource
import com.blogspot.hellosrinath.mvvm_tmdb.domain.repository.ArtistRepository

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource
) : ArtistRepository {
    override suspend fun getArtist(): List<Artist>? {
        TODO("Not yet implemented")
    }

    override suspend fun updateArtist(): List<Artist>? {
        TODO("Not yet implemented")
    }
}
package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasourceImpl

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.Artist
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.ArtistList
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.ArtistCacheDatasource

class ArtistCacheDatasourceImpl : ArtistCacheDatasource {
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> = artistList

    override suspend fun savesArtistToCache(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }
}
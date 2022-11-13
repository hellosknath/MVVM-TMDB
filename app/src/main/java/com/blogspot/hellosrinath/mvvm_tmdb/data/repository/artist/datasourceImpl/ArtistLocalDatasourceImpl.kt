package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasourceImpl

import com.blogspot.hellosrinath.mvvm_tmdb.data.db.ArtistDao
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.Artist
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.ArtistLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDatasourceImpl(private val artistDao: ArtistDao):ArtistLocalDatasource {
    override suspend fun getArtistFromLocalDb(): List<Artist> = artistDao.getArtist()

    override suspend fun saveArtistToLocalDb(artist: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artist)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtist()
        }
    }
}
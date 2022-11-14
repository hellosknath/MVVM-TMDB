package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist

import android.util.Log
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist.*
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.*
import com.blogspot.hellosrinath.mvvm_tmdb.domain.repository.ArtistRepository
import retrofit2.Response

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource
) : ArtistRepository {
    private val TAG = "ArtistRepositoryImpl"

    override suspend fun getArtist(): List<Artist> = getArtistFromCache()

    override suspend fun updateArtist(): List<Artist>? {
        val newArtistList: List<Artist> = getArtistFromAPI()
        artistLocalDatasource.clearAll()
        artistLocalDatasource.saveArtistToLocalDb(newArtistList)
        artistCacheDatasource.savesArtistToCache(newArtistList)
        return newArtistList
    }

    suspend fun getArtistFromAPI(): List<Artist> {
        lateinit var artistList: List<Artist>

        try {
            val response: Response<ArtistList> = artistRemoteDatasource.getArtist()
            val body: ArtistList? = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (e: Exception) {
            Log.i(TAG, "getArtistFromAPI: ${e.message.toString()}")
        }
        return artistList
    }

    suspend fun getArtistFromDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDatasource.getArtistFromLocalDb()
        } catch (e: Exception) {
            Log.i(TAG, "getArtistFromDB: ${e.message.toString()}")
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromAPI()
            artistLocalDatasource.saveArtistToLocalDb(artistList)
        }
        return artistList
    }

    suspend fun getArtistFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDatasource.getArtistFromCache()
        } catch (e: Exception) {
            Log.i(TAG, "getArtistFromCache: ${e.message.toString()}")
        }
        if (artistList.size > 0) {
            return artistList
        } else {
            artistList = getArtistFromDB()
            artistCacheDatasource.savesArtistToCache(artistList)
        }
        return artistList
    }
}
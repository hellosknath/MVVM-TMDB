package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShow
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShowList

interface TvShowLocalDataSource {
    suspend fun getTvShowFromDb(): List<TvShow>
    suspend fun saveTvShowToDb(tvShow: List<TvShow>)
    suspend fun deleteAll()
}
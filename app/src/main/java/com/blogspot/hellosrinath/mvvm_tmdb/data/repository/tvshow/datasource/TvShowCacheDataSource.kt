package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShow

interface TvShowCacheDataSource {
    suspend fun getTvShowFromCache(): List<TvShow>
    suspend fun saveTvShowToCache(tvShow: List<TvShow>)
}
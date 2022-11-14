package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasourceImpl

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShow
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl : TvShowCacheDataSource {
    private var tvShowsList = ArrayList<TvShow>()
    override suspend fun getTvShowFromCache(): List<TvShow> {
        return tvShowsList
    }

    override suspend fun saveTvShowToCache(tvShow: List<TvShow>) {
        tvShowsList.clear()
        tvShowsList = ArrayList(tvShow)
    }
}
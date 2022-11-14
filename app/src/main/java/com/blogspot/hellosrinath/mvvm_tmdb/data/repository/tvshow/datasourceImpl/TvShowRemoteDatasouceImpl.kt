package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasourceImpl

import com.blogspot.hellosrinath.mvvm_tmdb.data.api.TMDBService
import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShowList
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}
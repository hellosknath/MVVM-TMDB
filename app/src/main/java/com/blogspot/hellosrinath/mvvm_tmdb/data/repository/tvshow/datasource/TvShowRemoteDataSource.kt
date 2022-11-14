package com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getShows():Response<TvShowList>
}
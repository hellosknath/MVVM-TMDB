package com.blogspot.hellosrinath.mvvm_tmdb.domain.repository

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShow

interface TvShowsRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}
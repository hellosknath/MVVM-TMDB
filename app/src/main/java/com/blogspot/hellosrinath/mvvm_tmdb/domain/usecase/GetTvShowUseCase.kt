package com.blogspot.hellosrinath.mvvm_tmdb.domain.usecase

import com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow.TvShow
import com.blogspot.hellosrinath.mvvm_tmdb.domain.repository.TvShowsRepository

class GetTvShowUseCase(private val tvShowsRepository: TvShowsRepository) {
    suspend fun execute(): List<TvShow>? = tvShowsRepository.getTvShows()
}
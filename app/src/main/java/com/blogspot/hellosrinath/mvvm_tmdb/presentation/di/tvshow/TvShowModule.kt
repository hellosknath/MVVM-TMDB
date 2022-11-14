package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.tvshow

import com.blogspot.hellosrinath.mvvm_tmdb.domain.usecase.GetTvShowUseCase
import com.blogspot.hellosrinath.mvvm_tmdb.domain.usecase.UpdateTvShowUseCase
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.tv.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {
    @TvShowScope
    @Provides
    fun tvShowViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowUseCase,
            updateTvShowUseCase
        )
    }
}
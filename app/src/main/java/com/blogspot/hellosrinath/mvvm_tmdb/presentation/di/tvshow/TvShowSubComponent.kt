package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.tvshow

import com.blogspot.hellosrinath.mvvm_tmdb.presentation.tv.TvActivity
import dagger.Subcomponent


@TvShowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvActivity: TvActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): TvShowSubComponent
    }
}
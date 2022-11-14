package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.movie

import com.blogspot.hellosrinath.mvvm_tmdb.presentation.movie.MovieActivity
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSupComponent {
    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSupComponent
    }
}
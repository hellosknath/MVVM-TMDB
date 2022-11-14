package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.movie

import com.blogspot.hellosrinath.mvvm_tmdb.domain.usecase.GetMoviesUseCase
import com.blogspot.hellosrinath.mvvm_tmdb.domain.usecase.UpdateMoviesUseCase
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Scope

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}
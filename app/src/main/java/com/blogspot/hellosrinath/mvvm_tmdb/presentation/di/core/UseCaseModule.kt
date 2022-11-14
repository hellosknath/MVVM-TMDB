package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.core

import com.blogspot.hellosrinath.mvvm_tmdb.domain.repository.ArtistRepository
import com.blogspot.hellosrinath.mvvm_tmdb.domain.repository.MovieRepository
import com.blogspot.hellosrinath.mvvm_tmdb.domain.repository.TvShowsRepository
import com.blogspot.hellosrinath.mvvm_tmdb.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdaeMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetArtistUseCase(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistUseCase(artistRepository: ArtistRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowsRepository: TvShowsRepository): GetTvShowUseCase {
        return GetTvShowUseCase(tvShowsRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowsRepository: TvShowsRepository): UpdateTvShowUseCase {
        return UpdateTvShowUseCase(tvShowsRepository)
    }
}
package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.artist

import com.blogspot.hellosrinath.mvvm_tmdb.domain.usecase.GetArtistUseCase
import com.blogspot.hellosrinath.mvvm_tmdb.domain.usecase.UpdateArtistUseCase
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistUseCase
        )
    }

}
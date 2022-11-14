package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.artist

import com.blogspot.hellosrinath.mvvm_tmdb.presentation.artist.ArtistActivity
import dagger.Subcomponent

@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSupComponent {
    fun inject(artistActivity: ArtistActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): ArtistSupComponent
    }
}
package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.core

import android.content.Context
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.artist.ArtistSupComponent
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.movie.MovieSupComponent
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.tvshow.TvShowSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(
    subcomponents = [
        MovieSupComponent::class,
        ArtistSupComponent::class,
        TvShowSubComponent::class
    ]
)
class AppModule(private val context: Context) {
    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}
package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.core

import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.artist.ArtistSupComponent
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.movie.MovieSupComponent
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {
    fun movieSubComponent(): MovieSupComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSupComponent.Factory
}
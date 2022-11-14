package com.blogspot.hellosrinath.mvvm_tmdb.presentation

import android.app.Application
import com.blogspot.hellosrinath.mvvm_tmdb.BuildConfig
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.Injector
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.artist.ArtistSupComponent
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.core.*
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.movie.MovieSupComponent
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.tvshow.TvShowSubComponent

class App : Application(), Injector {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSupComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSupComponent {
        return appComponent.artistSubComponent().create()
    }
}
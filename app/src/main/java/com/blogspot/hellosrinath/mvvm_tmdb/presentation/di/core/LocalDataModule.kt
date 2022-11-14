package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.core

import com.blogspot.hellosrinath.mvvm_tmdb.data.db.ArtistDao
import com.blogspot.hellosrinath.mvvm_tmdb.data.db.MovieDao
import com.blogspot.hellosrinath.mvvm_tmdb.data.db.TvShowDao
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.ArtistLocalDatasource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasourceImpl.ArtistLocalDatasourceImpl
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource.MovieLocalDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasourceImpl.MovieLocalDataSourceImpl
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMoveLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDatasource {
        return ArtistLocalDatasourceImpl(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

}
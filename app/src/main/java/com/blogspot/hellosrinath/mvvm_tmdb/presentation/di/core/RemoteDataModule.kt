package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.core

import com.blogspot.hellosrinath.mvvm_tmdb.data.api.TMDBService
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.ArtistRemoteDatasource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasourceImpl.ArtistRemoteDatasourceImpl
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource.MovieRemoteDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasourceImpl.MovieRemoteDataSourceImpl
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService): ArtistRemoteDatasource {
        return ArtistRemoteDatasourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }
}
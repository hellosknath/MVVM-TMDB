package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.core

import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.ArtistRepositoryImpl
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.ArtistCacheDatasource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.ArtistLocalDatasource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.ArtistRemoteDatasource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.MovieRepositoryImpl
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource.MovieLocalDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource.MovieRemoteDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource.MoviesCacheDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.TvShowRepositoryImpl
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource.TvShowLocalDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource.TvShowRemoteDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.domain.repository.ArtistRepository
import com.blogspot.hellosrinath.mvvm_tmdb.domain.repository.MovieRepository
import com.blogspot.hellosrinath.mvvm_tmdb.domain.repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        moviesCacheDataSource: MoviesCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            moviesCacheDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDatasource,
        artistLocalDatasource: ArtistLocalDatasource,
        artistCacheDatasource: ArtistCacheDatasource
    ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDatasource,
            artistCacheDatasource
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowsRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }
}
package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.core

import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasource.ArtistCacheDatasource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.artist.datasourceImpl.ArtistCacheDatasourceImpl
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasource.MoviesCacheDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.movies.datasourceImpl.MovieCacheDataSourceImpl
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasource.TvShowCacheDataSource
import com.blogspot.hellosrinath.mvvm_tmdb.data.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MoviesCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDatasource {
        return ArtistCacheDatasourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCasheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }
}
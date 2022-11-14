package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.blogspot.hellosrinath.mvvm_tmdb.data.db.ArtistDao
import com.blogspot.hellosrinath.mvvm_tmdb.data.db.MovieDao
import com.blogspot.hellosrinath.mvvm_tmdb.data.db.TMDBDatabase
import com.blogspot.hellosrinath.mvvm_tmdb.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabse(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context, TMDBDatabase::class.java,
            "tmdbclient"
        ).build()
    }

    @Singleton
    @Provides
    fun provideMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun provideTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvDao()
    }
}
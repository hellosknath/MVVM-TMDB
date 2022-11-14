package com.blogspot.hellosrinath.mvvm_tmdb.presentation.di

import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.artist.ArtistSupComponent
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.movie.MovieSupComponent
import com.blogspot.hellosrinath.mvvm_tmdb.presentation.di.tvshow.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent(): MovieSupComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSupComponent
}
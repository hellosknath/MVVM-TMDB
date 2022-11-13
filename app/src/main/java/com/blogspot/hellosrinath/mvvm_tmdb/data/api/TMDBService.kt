package com.blogspot.hellosrinath.mvvm_tmdb.data.api

import com.blogspot.hellosrinath.mvvm_tmdb.data.ArtistList
import com.blogspot.hellosrinath.mvvm_tmdb.data.MovieList
import com.blogspot.hellosrinath.mvvm_tmdb.data.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<TvShowList>


    @GET("person/popular")
    suspend fun getPopularArtists(
        @Query(
            "api_key"
        ) apiKey: String
    ): Response<ArtistList>


}
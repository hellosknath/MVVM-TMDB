package com.blogspot.hellosrinath.mvvm_tmdb.data


import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val results: List<Movie>,
)
package com.blogspot.hellosrinath.mvvm_tmdb.data


import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val results: List<TvShow>,
)
package com.blogspot.hellosrinath.mvvm_tmdb.data


import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("results")
    val results: List<Artist>,
)
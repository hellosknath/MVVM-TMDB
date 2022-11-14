package com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow

import com.google.gson.annotations.SerializedName

data class TvShowList(
    @SerializedName("results")
    val tvshows: List<TvShow>,
)
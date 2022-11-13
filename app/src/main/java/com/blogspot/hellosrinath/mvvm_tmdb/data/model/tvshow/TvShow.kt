package com.blogspot.hellosrinath.mvvm_tmdb.data.model.tvshow

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_tvShows")
data class TvShow(
    @SerializedName("first_air_date")
    val firstAirDate: String?,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
)
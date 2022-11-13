package com.blogspot.hellosrinath.mvvm_tmdb.data.model.artist


import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "popular_artists")
data class Artist(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)
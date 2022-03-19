package com.example.assignment3.model


import com.google.gson.annotations.SerializedName

data class RockArtists(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Result>,


    @SerializedName("artistName")
    val artistName: String,
    @SerializedName("collectionName")
    val collectionName: String,
    @SerializedName("artworkUrl60")
    val artworkUrl60: String,
    @SerializedName("trackPrice")
    val trackPrice: Double
)
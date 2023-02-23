package com.example.album.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val collectionId: Long,
    val collectionType: String,
    val collectionName: String,
    val collectionViewUrl: String,
    val collectionPrice: Double,
    val collectionExplicitness: String,
    val artistId: Long,
    val artistName: String,
    val artistViewUrl: String,
    @SerializedName("artworkUrl60")
    val thumbnail: String,
    @SerializedName("artworkUrl100")
    val img: String,
    val contentAdvisoryRating: String,
    val trackCount: Int,
    val copyright: String,
    val country: String,
    val currency: String,
    val releaseDate: String,
    val primaryGenreName: String,
    var isBookmark: Boolean = false
) : Parcelable
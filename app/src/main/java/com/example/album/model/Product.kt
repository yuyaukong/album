package com.example.album.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val wrapperType: String,
    val collectionType: String,
    val artistId: Long,
    val collectionId: Long,
    val artistName: String,
    val collectionName: String,
    val artistViewUrl: String,
    val collectionViewUrl: String,
    val artworkUrl60: String,
    val artworkUrl100: String,
    val collectionPrice: Double,
    val collectionExplicitness: String,
    val contentAdvisoryRating: String,
    val trackCount: Int,
    val copyright: String,
    val country: String,
    val currency: String,
    val releaseDate: String,
    val primaryGenreName: String
) : Parcelable
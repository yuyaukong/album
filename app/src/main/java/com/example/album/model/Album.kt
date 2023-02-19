package com.example.album.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    val resultCount: Int,
    val results: List<Product> = listOf()
) : Parcelable
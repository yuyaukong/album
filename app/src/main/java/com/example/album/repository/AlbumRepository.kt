package com.example.album.repository

import com.example.album.model.Product
import kotlinx.coroutines.flow.Flow

interface  AlbumRepository {
    suspend fun getProductList(): Flow<List<Product>>

    suspend fun updateProductWithBookmark(collectionId: Long, isBookmark: Boolean)

}
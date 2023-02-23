package com.example.album.domain.usecase

import com.example.album.model.Product
import kotlinx.coroutines.flow.*


interface AlbumUseCase {

    suspend fun getProductListWithBookmark(): Flow<List<Product>>

    suspend fun updateProductWithBookmark(collectionId: Long, isBookmark: Boolean)

}
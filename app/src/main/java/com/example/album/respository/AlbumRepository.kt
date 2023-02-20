package com.example.album.respository

import com.example.album.model.Product
import kotlinx.coroutines.flow.Flow

interface  AlbumRepository {
    suspend fun getProductList(): Flow<List<Product>>

}
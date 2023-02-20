package com.example.album.domain.usecase

import com.example.album.model.Product
import kotlinx.coroutines.flow.*


interface AlbumUseCase {

    suspend fun getProductList(): Flow<List<Product>>

}
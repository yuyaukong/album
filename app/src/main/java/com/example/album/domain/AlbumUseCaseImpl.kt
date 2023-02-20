package com.example.album.domain.usecase

import com.example.album.model.Product
import com.example.album.respository.AlbumRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import javax.inject.Inject


@ExperimentalCoroutinesApi
class AlbumUseCaseImpl @Inject constructor(
    private val albumRepository: AlbumRepository
) : AlbumUseCase {

    override suspend fun getProductList(): Flow<List<Product>> {
        return albumRepository.getProductList()
    }

}

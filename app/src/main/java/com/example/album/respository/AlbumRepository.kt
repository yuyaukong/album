package com.example.album.respository

import com.example.album.model.Album
import com.example.album.model.Product

interface  AlbumRepository {

    suspend fun getAlbum(): Album
    suspend fun getProducts(): List<Product>

}
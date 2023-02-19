package com.example.album.respository

import com.example.album.model.Album
import kotlinx.coroutines.flow.Flow

interface  AlbumRepository {
    suspend fun getAlbum(): Flow<Album>

}
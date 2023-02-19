package com.example.album.respository

import com.example.album.BuildConfig
import com.example.album.model.Album
import com.example.album.network.AlbumApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class  AlbumRepositoryImpl(
    private val service: AlbumApiService
): AlbumRepository {

    override suspend fun getAlbum(): Flow<Album> {
        return flow {
            val result = service.getAlbum(BuildConfig.API_ALBUM_URL)
            emit(result)
        }.flowOn(Dispatchers.IO)
    }

}
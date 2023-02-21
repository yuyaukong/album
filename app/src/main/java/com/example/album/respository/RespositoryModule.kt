package com.example.album.respository

import com.example.album.network.AlbumApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RespositoryModule {

    @ExperimentalCoroutinesApi
    @Provides
    @Singleton
    fun provideAlbumRespository(
        albumApiService: AlbumApiService
    ): AlbumRepository {
        return AlbumRepositoryImpl(albumApiService)
    }

}
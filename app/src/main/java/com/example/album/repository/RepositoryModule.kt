package com.example.album.repository

import android.content.Context
import com.example.album.network.AlbumApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @ExperimentalCoroutinesApi
    @Provides
    @Singleton
    fun provideAlbumRespository(
        albumApiService: AlbumApiService,
        context: Context
    ): AlbumRepository {
        return AlbumRepositoryImpl(albumApiService, context)
    }

}
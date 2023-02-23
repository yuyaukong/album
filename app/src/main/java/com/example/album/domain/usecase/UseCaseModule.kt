package com.example.album.domain.usecase

import com.example.album.repository.AlbumRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @ExperimentalCoroutinesApi
    @Provides
    @Singleton
    fun provideAlbumUseCase(
        albumRepository: AlbumRepository
    ): AlbumUseCase {
        return AlbumUseCaseImpl(albumRepository)
    }

}
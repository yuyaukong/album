package com.example.album.network

import com.example.album.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [OkhttpModule::class])
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideAlbumApiService(okHttpClient: OkHttpClient): AlbumApiService {
        return createRetrofit(okHttpClient)
            .create(AlbumApiService::class.java)
    }

    private fun createRetrofit(okClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_ALBUM_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okClient)
            .build()
    }

}
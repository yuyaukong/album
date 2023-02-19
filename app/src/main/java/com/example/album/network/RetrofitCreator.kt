package com.example.album.network

import com.example.album.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitCreator {

    private var mRetrofit: Retrofit? = null

    @Synchronized
    fun getRetrofit(): Retrofit? {
        if (mRetrofit == null) {
            mRetrofit = createRetrofit(createOkClient())
        }
        return mRetrofit
    }

    private fun createRetrofit(okClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.API_ALBUM_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okClient)
            .build()
    }

    private fun createOkClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .build()
    }

}
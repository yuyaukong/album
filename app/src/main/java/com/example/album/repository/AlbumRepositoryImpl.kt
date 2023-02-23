package com.example.album.repository

import android.content.Context
import androidx.preference.PreferenceManager
import com.example.album.model.Product
import com.example.album.network.AlbumApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class  AlbumRepositoryImpl @Inject constructor(
    private val service: AlbumApiService,
    private val context: Context
): AlbumRepository {

    //TODO Use room database instead
    override suspend fun getProductList(): Flow<List<Product>> {
        return flow {
            val productList = service.getAlbum().results
            emit(productList.map {
                it.isBookmark = isBookmark(it.collectionId)
                return@map it
            })
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun updateProductWithBookmark(collectionId: Long, isBookmark: Boolean) {
        setBookmark(collectionId, isBookmark)
    }

    private fun isBookmark(collectionId: Long): Boolean {
        val preference = PreferenceManager.getDefaultSharedPreferences(context)
        return preference.getBoolean(String.format("isBookmark_$collectionId"), false)
    }

    private fun setBookmark(collectionId: Long, isBookmark: Boolean) {
        val preference = PreferenceManager.getDefaultSharedPreferences(context)
        preference.edit().putBoolean(String.format("isBookmark_$collectionId"), isBookmark).apply()
    }

}
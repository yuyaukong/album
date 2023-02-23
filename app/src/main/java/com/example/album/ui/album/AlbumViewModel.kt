package com.example.album.ui.album

import android.util.Log
import androidx.lifecycle.*
import com.example.album.domain.usecase.AlbumUseCase
import com.example.album.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
        private val albumUseCase: AlbumUseCase
) : ViewModel() {

    private val collectionIdToPositionMap = mutableMapOf<Int, Long>()
    private val _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>>
        get() = _productList

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            albumUseCase.getProductListWithBookmark()
                .collectLatest {
                    _productList.value = it
                }
        }
    }

    fun onClick(product: Product) {
        CoroutineScope(Dispatchers.IO).launch {
            val collectionId = product.collectionId
            albumUseCase.updateProductWithBookmark(collectionId, !product.isBookmark)

            _productList.postValue(productList.value?.map {
                if(it.collectionId == collectionId) {
                    it.isBookmark = !it.isBookmark
                }
                return@map it
            })
        }
    }

}

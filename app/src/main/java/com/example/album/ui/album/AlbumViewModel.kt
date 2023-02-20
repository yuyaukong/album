package com.example.album.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.album.domain.usecase.AlbumUseCase
import com.example.album.model.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
        private val albumUseCase: AlbumUseCase
) : ViewModel() {

    private val _productList = MutableLiveData<List<Product>>()
    val productList: LiveData<List<Product>>
        get() = _productList

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            albumUseCase.getProductList()
                .collectLatest {
                    _productList.value = it
                }
        }
    }

}

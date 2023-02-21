package com.example.album.network

import com.example.album.model.Album
import retrofit2.http.GET
import retrofit2.http.Url

interface  AlbumApiService {

    @GET("search?term=jack+johnson&entity=album")
    suspend fun getAlbum(): Album

}
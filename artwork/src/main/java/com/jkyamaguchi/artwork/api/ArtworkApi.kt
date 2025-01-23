package com.jkyamaguchi.artwork.api

import com.jkyamaguchi.artwork.data.model.ArtworkDto
import retrofit2.http.GET

interface ArtworkApi {

    @GET("artworks")
    fun getArtworks(): Result<ArtworkDto>

}
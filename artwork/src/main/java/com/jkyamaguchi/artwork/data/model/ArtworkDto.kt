package com.jkyamaguchi.artwork.data.model

import com.squareup.moshi.Json

data class ArtworkDto(
    val data: List<ArtworkData>
)

data class ArtworkData(
    val id: Long,
    val title: String,
    @Json(name = "image_id") val imageId: String?,
    @Json(name = "artist_titles") val artists: List<String>
)
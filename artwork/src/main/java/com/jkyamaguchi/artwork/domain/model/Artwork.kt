package com.jkyamaguchi.artwork.domain.model

data class Artwork(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val artists: List<String>
)
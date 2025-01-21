package com.jkyamaguchi.artwork.domain

data class Artwork(
    val id: Long,
    val title: String,
    val imageId: String,
    val artists: List<String>
)
package com.jkyamaguchi.artwork.data.mapper

import com.jkyamaguchi.artwork.data.ArtworkData
import com.jkyamaguchi.artwork.domain.Artwork

fun ArtworkData.toModel(): Artwork {
    return Artwork(
        id = this.id,
        title = this.title,
        imageId = this.imageId,
        artists = this.artists
    )
}

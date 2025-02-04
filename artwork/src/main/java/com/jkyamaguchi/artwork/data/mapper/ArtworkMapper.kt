package com.jkyamaguchi.artwork.data.mapper

import com.jkyamaguchi.artwork.data.model.ArtworkData
import com.jkyamaguchi.artwork.domain.model.Artwork

fun ArtworkData.toModel(imageMapper: ArtworkImageMapper): Artwork {
    return Artwork(
        id = this.id,
        title = this.title,
        imageUrl = imageMapper.imageUrl,
        artists = this.artists
    )
}

package com.jkyamaguchi.artwork.data.repository

import com.jkyamaguchi.artwork.api.ArtworkApi
import com.jkyamaguchi.artwork.data.mapper.ArtworkImageMapper
import com.jkyamaguchi.artwork.data.mapper.toModel
import com.jkyamaguchi.artwork.domain.model.Artwork
import com.jkyamaguchi.network.mapper.toModel
import javax.inject.Inject

class ArtworkRepository @Inject constructor(
    private val api: ArtworkApi
) : IArtworkRepository {

    override suspend fun getArtworks(): List<Artwork> {
        return api.getArtworks()
            .toModel().data
            .map { artworkData ->
                artworkData.toModel(
                    imageMapper = ArtworkImageMapper.Size843(imageId = artworkData.imageId)
                )
            }
    }
}
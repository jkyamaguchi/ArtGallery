package com.jkyamaguchi.artwork.data.repository

import com.jkyamaguchi.artwork.api.ArtworkApi
import com.jkyamaguchi.artwork.data.mapper.toModel
import com.jkyamaguchi.artwork.data.model.ArtworkData
import com.jkyamaguchi.artwork.domain.model.Artwork
import com.jkyamaguchi.network.mapper.toModel
import javax.inject.Inject

class ArtworkRepository @Inject constructor(
    private val api: ArtworkApi
) : IArtworkRepository {

    override fun getArtworks(): List<Artwork> {
        return api.getArtworks()
            .toModel().data
            .map(ArtworkData::toModel)
    }
}
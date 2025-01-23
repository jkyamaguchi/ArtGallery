package com.jkyamaguchi.artwork.domain.usecase

import com.jkyamaguchi.artwork.data.repository.IArtworkRepository
import com.jkyamaguchi.artwork.domain.model.Artwork
import javax.inject.Inject

class ListArtworkUseCase @Inject constructor( // Hilt injects object
    private val repository: IArtworkRepository
) : IListArtworkUseCase{


    override fun invoke(): List<Artwork> {
        return repository.getArtworks()
    }


}
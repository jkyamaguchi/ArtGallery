package com.jkyamaguchi.artwork.domain.usecase

import com.jkyamaguchi.artwork.domain.model.Artwork

interface IListArtworkUseCase {
    suspend operator fun invoke(): List<Artwork>
}
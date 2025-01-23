package com.jkyamaguchi.artwork.domain.usecase

import com.jkyamaguchi.artwork.domain.model.Artwork

interface IListArtworkUseCase {
    operator fun invoke(): List<Artwork>
}
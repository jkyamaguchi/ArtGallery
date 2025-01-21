package com.jkyamaguchi.artwork.data.repository

import com.jkyamaguchi.artwork.domain.Artwork

interface IArtworkRepository {

    fun getArtworks(): List<Artwork>


}
package com.jkyamaguchi.artwork.data.mapper

sealed class ArtworkImageMapper {

    companion object {
        // The API documentation recommends to use config.iiif_url JSON attribute instead of hardcoding it
        private const val BASE_IMAGE_URL = "https://www.artic.edu/iiif/2"
        private const val EMPTY_URL = ""
    }

    abstract val imageId: String?
    abstract val imageUrl: String

    // Recommended size for smaller sizes
    // https://api.artic.edu/docs/#image-sizes
    // Increments in size: 200, 400, 600, 843
    data class Size200(override val imageId: String?) : ArtworkImageMapper() {
        override val imageUrl: String = if (imageId != null) {
            "$BASE_IMAGE_URL/$imageId/full/200,/0/default.jpg"
        } else {
            EMPTY_URL
        }
    }

    // Recommended size from api documentation
    data class Size843(override val imageId: String?) : ArtworkImageMapper() {
        override val imageUrl: String = if (imageId != null) {
            "$BASE_IMAGE_URL/$imageId/full/843,/0/default.jpg"
        } else {
            EMPTY_URL
        }
    }
}

package com.jkyamaguchi.artwork.di

import com.jkyamaguchi.artwork.api.ArtworkApi
import com.jkyamaguchi.artwork.data.repository.ArtworkRepository
import com.jkyamaguchi.artwork.data.repository.IArtworkRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Provides
    fun providesArtworkApi(retrofit: Retrofit): ArtworkApi {
        return retrofit.create(ArtworkApi::class.java)
    }

    @Binds
    abstract fun bindArtworkRepository(
        artworkRepository: ArtworkRepository
    ): IArtworkRepository
}

// Works according to ViewModel life cycle
@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    // TODO
}
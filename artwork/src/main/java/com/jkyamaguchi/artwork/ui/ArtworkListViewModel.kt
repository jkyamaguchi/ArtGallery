package com.jkyamaguchi.artwork.ui

import androidx.lifecycle.ViewModel
import com.jkyamaguchi.artwork.domain.usecase.IListArtworkUseCase
import javax.inject.Inject

class ArtworkListViewModel @Inject constructor(
    private val useCase: IListArtworkUseCase
) : ViewModel() {

}
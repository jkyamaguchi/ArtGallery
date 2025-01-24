package com.jkyamaguchi.artwork.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jkyamaguchi.artwork.domain.model.Artwork
import com.jkyamaguchi.artwork.domain.usecase.IListArtworkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtworkListViewModel @Inject constructor(
    private val useCase: IListArtworkUseCase
) : ViewModel() {

    private val _artworks = MutableLiveData<List<Artwork>>()

    val artworks: LiveData<List<Artwork>>
        get() = _artworks

    // Call UseCase for list artworks
    fun fetchArtworks(){
        viewModelScope.launch {
            _artworks.value = useCase() // useCase() called as function because the operator modifier
        }
    }

}
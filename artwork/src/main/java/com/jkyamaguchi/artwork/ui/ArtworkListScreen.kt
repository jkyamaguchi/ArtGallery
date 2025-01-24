package com.jkyamaguchi.artwork.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jkyamaguchi.artwork.domain.model.Artwork


@Composable
fun ArtworkListScreen(
    modifier: Modifier = Modifier,
    viewModel: ArtworkListViewModel = hiltViewModel<ArtworkListViewModel>()
) {
    // State
    val artworks = viewModel.artworks.observeAsState().value

    // API call
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchArtworks()
    }

    // UI
    LazyColumn(modifier = modifier) {
        items(artworks.orEmpty()) { artwork ->
            ArtworkRow(artwork = artwork)
        }
    }
}

@Composable
fun ArtworkRow(artwork: Artwork) {
    Text(
        text = artwork.title,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(vertical = 8.dp),
        textAlign = TextAlign.Start
    )
}

@Preview(showBackground = true)
@Composable
fun ArtworkListPreview() {
    ArtworkListScreen()
}
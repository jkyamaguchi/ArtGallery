package com.jkyamaguchi.artwork.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jkyamaguchi.artwork.domain.model.Artwork

@Composable
fun ArtworkListScreen(
    modifier: Modifier = Modifier
) {
    val artworks: List<Artwork> = emptyList()

    LazyColumn(modifier = modifier) {
        items(artworks) { artwork ->
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
package com.jkyamaguchi.artwork.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jkyamaguchi.artwork.R
import com.jkyamaguchi.artwork.domain.model.Artwork
import com.jkyamaguchi.artwork.ui.theme.ArtGalleryTheme


@Composable
fun ArtworkRoute(
    modifier: Modifier = Modifier,
    viewModel: ArtworkListViewModel = hiltViewModel<ArtworkListViewModel>()
){
    // State
    val artworks = viewModel.artworks.observeAsState().value.orEmpty()

    // API call
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchArtworks()
    }

    ArtworkListScreen(
        modifier = modifier,
        artworks = artworks
    )
}

@Composable
fun ArtworkListScreen(
    modifier: Modifier = Modifier,
    artworks: List<Artwork>
) {

    // UI
    ArtworkList(
        artworks = artworks,
        modifier = modifier
    )
}

@Composable
fun ArtistsRow(artist: String) {
    Text(
        text = artist,
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier.padding(vertical = 8.dp),
        textAlign = TextAlign.Start
    )
}

@Composable
fun ArtworkItem(
    artwork: Artwork,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        modifier = modifier
            .padding(8.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_general))
                .sizeIn(minHeight = 72.dp),
            verticalAlignment = Alignment.Top

        ){
            ArtworkInformation(
                title = artwork.title,
                artists = artwork.artists,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width (16.dp))

            ArtworkImage(artworkUrl = artwork.imageUrl)
        }
    }
}

@Composable
fun ArtworkInformation(
    title: String,
    artists: List<String>,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ){
        Text(
            text = title,
            style = MaterialTheme.typography.displaySmall
        )
        ArtistsList(artists.toList())
    }
}

@Composable
fun ArtistsList(artists: List<String>) {
    Column {
        artists.forEach { artist ->
            ArtistsRow(artist)
        }
    }
}

@Composable
fun ArtworkImage(
    artworkUrl: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(dimensionResource(id = R.dimen.image_size))
            .clip(MaterialTheme.shapes.small),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current).data(artworkUrl)
                .crossfade(true).build(),
            //error = painterResource(R.drawable.error), TODO add error image
            //placeholder = painterResource(R.drawable.placeholder), TODO add placeholder image
            contentDescription = stringResource(R.string.artwork_image_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ArtworkList(
    artworks: List<Artwork>,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier
    ){
        items(artworks){ artwork ->
            ArtworkItem(
                artwork = artwork
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkListPreview() {
    ArtGalleryTheme {
        ArtworkListScreen(
            artworks = listOf(
                Artwork(
                    id = 1,
                    title = "Artwork 1",
                    imageUrl = "",
                    artists = listOf("Artist 1")
                ),
                Artwork(
                    id = 2,
                    title = "Artwork 2",
                    imageUrl = "",
                    artists = listOf("Artist 2")
                ),
                Artwork(
                    id = 3,
                    title = "Artwork 3",
                    imageUrl = "",
                    artists = listOf("Artist 1", "Artist 2")
                )
            ),
            modifier = Modifier.padding(8.dp)
        )
    }

}

@Preview
@Composable
fun ArtworkPreviewCard(){
    val artwork = Artwork(
        id = 1,
        title = "Artwork 1",
        imageUrl = "",
        artists = listOf("Artist 1")
    )
    ArtGalleryTheme {
        ArtworkItem(artwork)
    }
}

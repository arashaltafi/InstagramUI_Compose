package com.arash.altafi.socialmedia.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.arash.altafi.socialmedia.data.MockData
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShowStoryScreen(index: Int) {

    Card(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            GlideImage(
                modifier = Modifier.fillMaxSize(),
                imageModel = MockData.stories[index].image,
                // shows a progress indicator when loading an image.
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                },
                contentScale = ContentScale.Crop,
                failure = {
                    Text(text = "image request failed.")
                }
            )
        }
    }

}
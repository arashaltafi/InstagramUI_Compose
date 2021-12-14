package com.arash.altafi.socialmedia.ui.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.arash.altafi.socialmedia.models.Story
import com.arash.altafi.socialmedia.ui.theme.RedColor
import com.arash.altafi.socialmedia.ui.theme.ShadowColor
import com.arash.altafi.socialmedia.ui.theme.VioletColor
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun StoriesView(stories: ArrayList<Story> , navController : NavController) {
    LazyRow(Modifier.padding(5.dp,0.dp)) {

        items(stories.size + 1) { index ->
            if (index == 0) {
                StoryItem(
                    story = Story("", "https://arashaltafi.ir/Social_Media/story-00.jpg", false),
                    isMySelf = true,
                    navController = navController,
                    index = 0
                )
            } else {
                StoryItem(stories[index - 1], index = index - 1 , navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StoryItem(story: Story, index : Int , navController: NavController, isMySelf: Boolean = false) {

    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.padding(4.dp),
        elevation = 8.dp,
        border = if (!isMySelf) {
            BorderStroke(2.dp, if (story.isLive) RedColor else VioletColor)
        } else {
            null
        },
        onClick = {
            if (!isMySelf) {
                if (story.isLive) {
                    Toast.makeText(context, "Click on Live", Toast.LENGTH_SHORT).show()
                } else {
//                    Toast.makeText(context , "Click on Story" , Toast.LENGTH_SHORT).show()
                    navController.navigate("showStory/$index")
                }
            } else {
                //Todo : go to add story compose
            }

        }

    ) {
        Box(
            modifier = Modifier
                .height(100.dp)
                .width(70.dp)
        ) {
            GlideImage(
                imageModel = story.image,
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
            Box(
                modifier = Modifier
                    .background(ShadowColor)
                    .fillMaxSize()
            )
            if (isMySelf) {
                Icon(
                    Icons.Outlined.AddCircle,
                    contentDescription = "add story",
                    modifier = Modifier
                        .size(40.dp)
                        .align(Alignment.Center),
                    tint = Color.White
                )
            }
            Text(
                text = story.username,
                color = Color.White,
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )
            if (story.isLive) {
                Text(
                    text = "LIVE",
                    Modifier
                        .background(RedColor)
                        .align(Alignment.BottomCenter)
                        .padding(3.dp, 1.dp),
                    color = Color.White,
                    fontSize = 10.sp
                )
            }
        }
    }
}
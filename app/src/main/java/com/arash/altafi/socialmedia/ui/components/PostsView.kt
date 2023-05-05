package com.arash.altafi.socialmedia.ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arash.altafi.socialmedia.R
import com.arash.altafi.socialmedia.models.Post
import com.arash.altafi.socialmedia.ui.theme.AppGray
import com.arash.altafi.socialmedia.ui.theme.RedColor
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PostsView(posts: ArrayList<Post>) {

    LazyColumn {
        items(posts.size) { index ->
            PostItem(posts[index])
        }
    }

}

@Composable
fun PostItem(post: Post) {

    val context = LocalContext.current

    var liked by remember { mutableStateOf(false) }

    Column(
        Modifier.padding(10.dp)
    ) {
        Row {
            Card(
                modifier = Modifier.size(40.dp),
                shape = RoundedCornerShape(15.dp),
                elevation = 8.dp
            ) {
                GlideImage(
                    imageModel = post.user.image,
                    // shows a progress indicator when loading an image.
                    loading = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Center)
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .align(Center)
                            )
                        }
                    },
                    contentScale = ContentScale.Crop,
                    failure = {
                        Text(text = "image request failed.")
                    }
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Column(
                Modifier.weight(1f)
            ) {
                Text(
                    text = post.user.fullName,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = post.location,
                    fontSize = 12.sp,
                    color = AppGray
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    Icons.Filled.MoreVert,
                    contentDescription = "more",
                    Modifier
                        .size(26.dp)
                        .align(CenterVertically)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(15.dp),
            elevation = 8.dp
        ) {
            GlideImage(
                modifier = Modifier.fillMaxSize(),
                imageModel = post.image,
                // shows a progress indicator when loading an image.
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .align(Center)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .align(Center)
                        )
                    }
                },
                contentScale = ContentScale.Crop,
                failure = {
                    Text(text = "image request failed.")
                }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            IconButton(
                onClick = {
                    liked = !liked
                },
            ) {
                Icon(
                    if (liked) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "FavoriteBorder",
                    Modifier.size(28.dp),
                    tint = if (liked) RedColor else AppGray,
                )
            }

            IconButton(
                onClick = {
                    liked = !liked
                },
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_outline_add_comment_24),
                    contentDescription = "Add Comment",
                    Modifier.size(28.dp),
                    tint = AppGray,
                )
            }

            Spacer(
                modifier = Modifier
                    .height(8.dp)
                    .weight(1f)
            )

            IconButton(
                onClick = {
                    Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show()
                }
            ) {
                Icon(
                    Icons.Outlined.Send,
                    contentDescription = "Send",
                    Modifier.size(28.dp),
                    tint = AppGray
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = post.caption,
            fontSize = 12.sp,
            textAlign = TextAlign.Justify,
            color = AppGray
        )

        Spacer(modifier = Modifier.height(8.dp))

    }
}
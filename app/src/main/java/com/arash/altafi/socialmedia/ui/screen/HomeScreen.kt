package com.arash.altafi.socialmedia.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.arash.altafi.socialmedia.data.MockData
import com.arash.altafi.socialmedia.ui.components.PostsView
import com.arash.altafi.socialmedia.ui.components.StoriesView
import com.arash.altafi.socialmedia.ui.theme.LightGray

@Composable
fun HomeScreen(navController : NavController) {

    Column {
        StoriesView(MockData.stories , navController = navController)

        Spacer(modifier = Modifier.height(7.dp))

        Divider(
            modifier = Modifier.padding(15.dp , 0.dp),
            color = LightGray,
            thickness = 1.dp
        )

        Spacer(modifier = Modifier.height(7.dp))

        PostsView(MockData.posts)
    }

}
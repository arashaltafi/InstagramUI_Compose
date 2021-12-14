package com.arash.altafi.socialmedia.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arash.altafi.socialmedia.ui.theme.RedColor
import com.arash.altafi.socialmedia.ui.theme.VioletColor

@Composable
fun TopAppView() {

    Row(
        Modifier.padding(10.dp , 0.dp)
    ) {

        Text(
            text = "Social Media",
            color = if (isSystemInDarkTheme()) Color.White else VioletColor,
            fontFamily = FontFamily.Cursive,
            fontSize = 21.sp,
            modifier = Modifier
                .align(CenterVertically)
                .weight(1f)
        )

        IconButton(onClick = { /*TODO*/ }) {
            Box(
                contentAlignment = BottomEnd
            ) {
                Icon(
                    Icons.Filled.Send,
                    contentDescription = "send"
                )
                Card(
                    shape = RoundedCornerShape(50),
                    modifier = Modifier.size(14.dp)
                ) {
                    Text(
                        text = "+9",
                        Modifier.background(RedColor),
                        color = Color.White,
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }

}
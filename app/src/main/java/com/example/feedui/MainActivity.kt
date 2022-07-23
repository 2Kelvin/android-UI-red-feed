package com.example.feedui

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.feedui.ui.theme.FeedUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeedUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    feedUI()
                }
            }
        }
    }
}

@Composable
fun feedUI() {
    // parent Column
    Column(
        Modifier
            .fillMaxSize()
            .background(colorResource(R.color.bg_red))
    ) {
        // menu Row
        Row(
            Modifier
                .padding(top = 10.dp, bottom = 25.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // menu icon
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = null,
                tint = Color.White
            )
            Text(
                text = "Home",
                color = Color.White
            )
            Icon(
                imageVector = Icons.Outlined.ArrowForward,
                contentDescription = null,
                tint = Color.White
            )
        }
        // column profile & button
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //image-profile
            Image(
                painter = painterResource(R.drawable.pic),
                contentDescription = "Profile Picture",
                Modifier
                    .size(80.dp)
                    .clip(CircleShape)
        //add circular border            // .border(width = 2.dp, color = Color.White, Shape = RectangleShape)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RedFeedUIPreview() {
    FeedUITheme {
        feedUI()
    }
}
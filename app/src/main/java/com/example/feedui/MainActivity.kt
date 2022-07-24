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
import androidx.compose.material.*
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Row( // make the icons in this Row bigger
            Modifier
                .padding(top = 7.dp, bottom = 25.dp)
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
                // border(width = 2.dp, color = Color.White, Shape = RectangleShape) add circular border
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "June Lin",
                color = Color.White,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = "Photographer, lover of life and an adventurer." +
                        "This life is meant to be enjoyed.",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(310.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
            ) {
                Text(
                    text = "Follow",
                    modifier = Modifier.padding(10.dp, 5.dp),
                    fontSize = 16.sp
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
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
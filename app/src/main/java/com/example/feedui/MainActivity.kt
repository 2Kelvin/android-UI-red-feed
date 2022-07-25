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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowForward
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
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
// font poppins
val poppins = FontFamily(
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_bold, FontWeight.Bold)
)

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
                .padding(top = 7.dp, bottom = 25.dp, start = 15.dp, end = 15.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // menu icon
            Icon(
                imageVector = Icons.Outlined.Menu,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(26.dp)
            )
            Text( // align this Text vertically with the icons
                text = "Home",
                color = Color.White,
                fontFamily = poppins,
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            )
            Icon(
                imageVector = Icons.Outlined.ArrowForward,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(26.dp)
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
                    .size(90.dp)
                    .clip(CircleShape)
                // border(width = 2.dp, color = Color.White, Shape = RectangleShape) add circular border
            )
            Spacer(modifier = Modifier.height(25.dp))
            Text(
                text = "June Lin",
                color = Color.White,
                fontSize = 20.sp,
                fontFamily = poppins,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(7.dp))
            Text(
                text = "Photographer, lover of life and an adventurer." +
                        "This life is meant to be enjoyed.",
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(310.dp),
                fontFamily = poppins,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
            ) {
                Text(
                    text = "Follow",
                    modifier = Modifier.padding(10.dp, 5.dp),
                    fontSize = 16.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
        }

        // 2 posts cards

        // card 1
        Card(
            Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, top = 15.dp),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                Modifier.padding(15.dp)
            ) {
                Text(
                    text = "yesterday",
                    color = colorResource(R.color.greyed_out),
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 10.dp, bottom = 12.dp)
                )
                Text(
                    text = "We often question whether life is really worth it" +
                            "and if it can be enjoyed. I say life is what you make it",
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 15.dp)
                )
                Row(Modifier.width(150.dp)) {
                    // row likes
                    Row(Modifier.weight(1f)) {
                        Icon(
                            imageVector = Icons.Rounded.Favorite,
                            contentDescription = null,
                            tint = Color.Red
                        )
                        Text(
                            text = "45",
                            fontFamily = poppins,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    // row comments
                    Row(Modifier.weight(1f)) {
                        Icon(
                            imageVector = Icons.Rounded.Notifications,
                            contentDescription = null,
                            tint = colorResource(R.color.greyed_out)
                        )
                        Text(
                            text = "21",
                            fontFamily = poppins,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        // card 2
        Card(
            Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp, bottom = 15.dp),
            backgroundColor = Color.White,
            shape = RoundedCornerShape(10.dp)
        ) {
            Column(
                Modifier.padding(15.dp)
            ) {
                Text(
                    text = "2 days ago",
                    color = colorResource(R.color.greyed_out),
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 10.dp, bottom = 12.dp)
                )
                Text(
                    text = "June uploaded 4 new pictures",
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 15.dp)
                )
                //row pictures
                Row(
                    Modifier
                        .padding(bottom = 10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(R.drawable.pic),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .padding(end = 10.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.pic),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .padding(end = 10.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.pic),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .padding(end = 10.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.pic),
                        contentDescription = null,
                        modifier = Modifier
                            .size(70.dp)
                            .padding(end = 10.dp)
                    )
                }
                // row likes $ comments
                Row(Modifier.width(150.dp)) {
                    Row(Modifier.weight(1f)) {
                        Icon(
                            imageVector = Icons.Rounded.Favorite,
                            contentDescription = null,
                            tint = Color.Red
                        )
                        Text(
                            text = "33",
                            fontFamily = poppins,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Row(Modifier.weight(1f)) {
                        Icon(
                            imageVector = Icons.Rounded.Notifications,
                            contentDescription = null,
                            tint = colorResource(R.color.greyed_out)
                        )
                        Text(
                            text = "10",
                            fontFamily = poppins,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
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
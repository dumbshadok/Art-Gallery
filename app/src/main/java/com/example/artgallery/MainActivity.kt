package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtGalleryApp(
                        modifier = Modifier
                            .padding(innerPadding)
                            .systemBarsPadding()
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}

val selfPortrait = Artwork(R.drawable.van_gogh___self_portrait___, R.string.Van_Gogh___Self_Portrait___name, R.string.Van_Gogh___Self_Portrait___info)
val selfPortrait1 = Artwork(R.drawable.self_portrait_1889_1_jpg_large, R.string.Van_Gogh___Self_Portrait___name, R.string.Van_Gogh___Self_Portrait___info)
val tieThomas = Artwork(R.drawable.unknown___tie_thomas, R.string.Unknown___Tie_Thomas___name, R.string.Unkown___Tie_Thomas___info)

val artworkList = listOf(selfPortrait,selfPortrait1, tieThomas)

@Composable
fun ArtGalleryApp(modifier: Modifier = Modifier) {

    var artId by remember{ mutableIntStateOf(0) }


    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxHeight()) {

        ArtworkImage(artworkList[artId].image, Modifier)
        ArtworkLabel(artworkList[artId].name, artworkList[artId].info)

        PreviousNextButtonRow(
            onClickPrevious = { artId =  when {
                artId <= 0 -> artworkList.size-1
                else -> artId-1
                    }},
            onClickNext = { artId =  when {
                artId >= artworkList.size-1 -> 0
                else -> artId+1
            }},
            modifier = Modifier)
    }
}

@Composable
private fun ArtworkImage(@DrawableRes artworkImage: Int, modifier: Modifier = Modifier) {



    Surface(
        shadowElevation = 16.dp,
        border = BorderStroke(16.dp, color = Color.White),
        modifier = modifier.padding(32.dp)
    ) {
        Image(
            painter = painterResource(artworkImage),
            contentDescription = null,
            modifier = modifier
//            )
        )
    }
}

@Composable
fun ArtworkLabel(@StringRes artworkName : Int, @StringRes artworkInfo: Int, modifier: Modifier = Modifier) {
    Column(
        modifier
            .background(color = Color.LightGray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        )
    {
        Text(
            text = stringResource(artworkName),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
        )
        Text(
            text = stringResource(artworkInfo),
       )
    }
}

@Composable
fun PreviousNextButtonRow(onClickPrevious: () -> Unit, onClickNext:() ->Unit, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()) {

        //PREVIOUS BUTTON
        Button(
            onClick = onClickPrevious,
            modifier
                .padding(16.dp)
                .weight(0.5f)

        ) {
            Text(
                text = stringResource(R.string.previous),
                Modifier,
                textAlign = TextAlign.Center,
            )
        }

        //NEXT BUTTON
        Button(
            onClick = onClickNext,
            modifier
                .padding(16.dp)
                .weight(0.5f)

        ) {
            Text(
                text = stringResource(R.string.next),
                Modifier,
                textAlign = TextAlign.Center,

            )

        }
    }
}


data class Artwork(@DrawableRes val image: Int, @StringRes val name: Int, @StringRes val info: Int)


@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun AppPreview() {
    ArtGalleryTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ArtGalleryApp(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
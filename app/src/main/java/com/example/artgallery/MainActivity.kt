package com.example.artgallery

import android.R.attr.name
import android.R.attr.value
import android.graphics.Paint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.mandatorySystemGesturesPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeGestures
import androidx.compose.foundation.layout.safeGesturesPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
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

@Composable
fun ArtGalleryApp(modifier: Modifier = Modifier) {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.vincent_van_gogh___self_portrait___),
            contentDescription = null,
            Modifier
                .size(400.dp)
                .padding(20.dp)
        )
        ArtworkLabel(modifier)
        PreviousNextButtonRow(modifier)
    }
}

@Composable
fun ArtworkLabel(modifier: Modifier = Modifier) {
    Column(
        Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        )
    {
        Text(
            text = stringResource(R.string.self_portrait_name),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
        )
        Text(
            text = stringResource(R.string.self_portrait_info)
        )
    }
}

@Composable
fun PreviousNextButtonRow(modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier.fillMaxWidth()) {
        Button(
            onClick = {},
            modifier.weight(0.5f).padding(16.dp)

        ) {
            Text(
                text = stringResource(R.string.previous),
                Modifier,
                textAlign = TextAlign.Center,


            )
        }
        Button(
            onClick = {},
            modifier.padding(16.dp).weight(0.5f)

        ) {
            Text(
                text = stringResource(R.string.next),
                Modifier,
                textAlign = TextAlign.Center,

            )

        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    ArtGalleryTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ArtGalleryApp(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
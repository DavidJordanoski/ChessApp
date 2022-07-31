package com.fict.chesspuzzle.ui.theme.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fict.chesspuzzle.ui.theme.ui.ui.theme.BoardColors
import com.fict.chesspuzzle.ui.theme.ui.ui.theme.ChessPuzzleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ChessPuzzleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChessPuzzleTheme {
        Scaffold(topBar = {
            TopAppBar {
                Text(text = "Chess Puzzle")
            }

        }) {

        }
        Column(
            Modifier
                .paddingFromBaseline(68.dp, 0.dp),
            verticalArrangement = Arrangement.Bottom
        ) {

            for (y in 0 until 8) {
                Row {
                    for (x in 0 until 8) {
                        val white = y % 2 == x % 2
                        val color = if (white) BoardColors.lightSquare else BoardColors.darkSquare
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .background(color)
                                .aspectRatio(1.0f)
                        ) {
                            if (y == 7) {
                                Text(
                                    text = "${'A' + x}",
                                    modifier = Modifier.align(Alignment.BottomEnd),
                                    style = MaterialTheme.typography.caption,
                                    color = Color.Black.copy(0.5f)
                                )
                            }
                            if (x == 0) {
                                Text(
                                    text = "${8 - y}",
                                    modifier = Modifier.align(Alignment.TopStart),
                                    style = MaterialTheme.typography.caption,
                                    color = Color.Black.copy(0.5f)
                                )
                            }
                        }
                    }
                }
            }
        }

    }
}
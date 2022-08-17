package com.fict.chesspuzzle.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.fict.chesspuzzle.ui.theme.ui.ui.theme.BoardColors

@Preview(showBackground = true)
@Composable
fun BoardBackground() {
        Column {
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

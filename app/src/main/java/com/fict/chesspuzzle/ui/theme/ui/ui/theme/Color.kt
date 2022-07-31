package com.fict.chesspuzzle.ui.theme.ui.ui.theme

import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)
val blueVariant = Color(0xFF003b8e)

object BoardColors {
    val lastMoveColor = blueVariant.copy(alpha = 0.5f)
    val lightSquare = Color(0xFFF0D9B5)
    val darkSquare = Color(0xFF946f51)
    val checkColor = Color.Red.copy(alpha = 0.5f)
    val attackColor = Color.Red.copy(alpha = 0.5f)
    val moveColor = lastMoveColor
}
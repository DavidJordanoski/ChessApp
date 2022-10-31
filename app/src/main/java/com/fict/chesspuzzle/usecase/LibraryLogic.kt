package com.fict.chesspuzzle.usecase


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.fict.chesspuzzle.R
import com.github.bhlangonijr.chesslib.*

class LibraryLogic {
    val board = Board()

    fun loadFenCode(fen:String?){
        return board.loadFromFen(fen)
    }

    @Composable
    fun drawPieces(x: Int, y: Int) {
        val col = File.allFiles[x]
        val row = Rank.allRanks[y]
        val sq = Square.encode(row, col)
        val piece = board.getPiece(sq)

        Image(painter = painterResource(id = imageResource(piece)), contentDescription = null)
    }

    @DrawableRes
    fun imageResource(piece: Piece): Int {
        return when (piece) {
            Piece.WHITE_PAWN -> R.drawable.white_pawn
            Piece.WHITE_KNIGHT -> R.drawable.white_knight
            Piece.WHITE_BISHOP -> R.drawable.white_bishop
            Piece.WHITE_ROOK -> R.drawable.white_rook
            Piece.WHITE_QUEEN -> R.drawable.white_queen
            Piece.WHITE_KING -> R.drawable.white_king
            Piece.BLACK_PAWN -> R.drawable.black_pawn
            Piece.BLACK_KNIGHT -> R.drawable.black_knight
            Piece.BLACK_BISHOP -> R.drawable.black_bishop
            Piece.BLACK_ROOK -> R.drawable.black_rook
            Piece.BLACK_QUEEN -> R.drawable.black_queen
            Piece.BLACK_KING -> R.drawable.black_king
            Piece.NONE -> R.drawable.emptysquare
        }
    }
}
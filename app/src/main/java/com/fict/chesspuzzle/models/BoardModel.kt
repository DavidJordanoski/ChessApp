package com.fict.chesspuzzle.models

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.fict.chesspuzzle.R
import com.github.bhlangonijr.chesslib.*
import com.github.bhlangonijr.chesslib.move.Move
import com.github.bhlangonijr.chesslib.move.MoveGenerator

open class BoardModel {
    val board = Board()

    //8x8 = 64

    // 0 1 2 3 4 5 6 7
    // 8 9 10...
    // .... .. .. .63

    // 0 1 2 3.......... 63

    val figures: List<SquareModel> = listOf() //8x8 ova ke se polni od FEN

    //0-7 ili 1-8
    fun getItemAt(x: Int, y: Int): String {
        val col = File.allFiles[x]
        val row = Rank.allRanks[y]
        val sq = Square.encode(row, col)
        val piece = board.getPiece(sq)
        return piece.fenSymbol //"r"
        //y*8+x
        //(y-1)*8+(x-1)
    }

  fun isRook(x: Int, y :Int): Boolean {
      val rook: String = "R"
      return if (getItemAt(x,y).equals(rook,true)) {
          println("True")
          true
      } else {
          println("False")
          false
      }
  }

  fun isWhite(x: Int, y :Int): Boolean {
      return if (
          getItemAt(x, y) == "R" ||
          getItemAt(x, y) == "N" ||
          getItemAt(x, y) == "B" ||
          getItemAt(x, y) == "Q" ||
          getItemAt(x, y) == "K" ||
          getItemAt(x, y) == "P") {

          println("True")
          true
      } else {
          println("False")
          false
      }
  }

  fun isEmpty(x: Int, y :Int): Boolean {
      val empty: String = "."
      return if (getItemAt(x,y).equals(empty,true)) {
          println("True")
          true
      } else {
          println("False")
          false
      }
  }
    @Composable
fun isSelected(x: Int, y: Int, selected: Boolean):Boolean {
    return if (selected) {
        val col = File.allFiles[x]
        val row = Rank.allRanks[y]
        val sq = Square.encode(row, col)
        val piece = board.getPiece(sq)
        println(piece.fenSymbol)
        if (getItemAt(x,y) == "R") {
            MoveGenerator.generateRookMoves(board, board.legalMoves())
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = null)
        }
        true
    } else false
}


    //tuka ke bidi i  conversion of "a8" vo (0,0)
    fun fromSquareToCoordinate(square: Square) {
        val file = square.file
        val rank = square.rank
        println("You printed ${file.ordinal},${rank.ordinal}")
    }

    @Composable
    fun drawPieces(x: Int, y: Int) {
        val col = File.allFiles[x]
        val row = Rank.allRanks[y]
        val sq = Square.encode(row, col)
        val piece = board.getPiece(sq)
        board.loadFromFen("rnbqpbnr/ppp1pppp/8/8/8/PPP2PPP/PPP2PPP/RNB1KBNR w KQkq - 0 1")
        board.doMove(Move(Square.A1, Square.A5))
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